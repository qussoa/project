package com.biz.product.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.product.domain.ProFileDTO;
import com.biz.product.persistence.FileDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileService {

	@Autowired
	SqlSession sqlSession;

	FileDao fileDao;

	@Autowired
	public void fileDao() {
		this.fileDao = sqlSession.getMapper(FileDao.class);
	}

	@Autowired
	String winFilePath;

	@Autowired
	String macFilePath;

	String fileUpLoadPath;
	/*
	 * macFilePath를 검사하여 path가 존재하면 파일 업로드 path를 macFilePath로 변경하고 그렇지 않으면
	 * winFilePath를 업로드 폴더로 쓰겠다
	 */

	@Autowired
	public void fileUpPath() {
		this.fileUpLoadPath = this.winFilePath;
		File path = new File(this.macFilePath);
		if (path.exists()) {
			this.fileUpLoadPath = this.macFilePath;
		}
	}

	private final String filesPath = "/bizwork/files/";

	/*
	 * 여러개의 파일들을 개별파일로 분리하여 file up() method에게 보내서 파일을 업로드하도록 하고 fileup()이 생성한 업로드
	 * 파일이름을 return 받아서 List에 추가한 후 파일이름들 List를 Controller로 return
	 */

	public List<ProFileDTO> filesUp(MultipartHttpServletRequest u_files) {

		if (u_files.getFile("u_files").getSize() < 1)
			return null;

		List<ProFileDTO> upFileList = new ArrayList<ProFileDTO>();

		try {
			for (MultipartFile file : u_files.getFiles("u_files")) {
				String upFileName = this.fileUp(file);
				ProFileDTO pf = ProFileDTO.builder().file_origin_name(file.getOriginalFilename())
						.file_upload_name(upFileName).build();

				upFileList.add(pf);
				log.debug("파일업로드 정보" + pf.toString());
			}
		} catch (Exception e) {
			log.debug("Exeption : " + e.getMessage());
			return null;
		}

		return upFileList;
	}

	/*
	 * fileUp() method에게 보내서 파일을 업로드하도록 하고
	 * 
	 */
	public String fileUp(MultipartFile u_file) throws Exception {

		// 업로드된 파일정보에서 파일이름만 추출
		// upFileName = UUID + originalFileName
		String orignName = u_file.getOriginalFilename();

		// tomcat server가 작동되고 있는곳에 대한 정보
		// getRealPath("/")
		// tomcat server가 우리 프로젝트를 서비스 할때
		// root로 설정하여 여러가지 정보를 저장하고 있는 폴더정보
		// upLoadPath : /product/files/

		if (u_file != null) {

			// /files/ 폴더에 대한 IO 정보를 추출
			File dir = new File(fileUpLoadPath);

			// 현재 서버에 /files/라는 폴더가 없으면
			if (!dir.exists()) {

				// 폴더를 생성해라
				dir.mkdirs();
			}

	
			String strUUID = UUID.randomUUID().toString();
			strUUID += orignName;

			File upLoadFile = new File(fileUpLoadPath, strUUID);

			try {

				u_file.transferTo(upLoadFile);

				return strUUID;

			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

	public void fileDelete(String p_file) {
		File dFile = new File(fileUpLoadPath, p_file);

		log.debug("삭제할 파일 : " + p_file);

		if (dFile.exists()) {
			boolean ok = dFile.delete();
			if (ok) {
				log.debug("파일 삭제 성공");
			} else {
				log.debug("파일 삭제 실패");
			}
		} else {
			log.debug("삭제할 파일이 없음");
		}
	}

	public ProFileDTO findByFileSeq(String file_seq) {
		return fileDao.findByFileSeq(file_seq);
	}
}
