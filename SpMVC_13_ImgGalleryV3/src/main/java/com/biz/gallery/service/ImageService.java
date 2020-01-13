package com.biz.gallery.service;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.repository.ImageDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("imgServiceV1")
public class ImageService {

	 protected final ImageDao imDao;
	 protected final FileService fService;
	 protected final ImageFileService ifService;

	@Autowired
	public ImageService(ImageDao imDao, FileService fService, ImageFileService ifService) {
		super();
		this.imDao = imDao;
		this.fService = fService;
		this.ifService = ifService;
	}

	public List<ImageVO> selectAll() {
		return imDao.selectAll();
	}

	public int insert(ImageVO imageVO) {

		// 1 파일 이름리스트를 추출
		List<String> fileList = imageVO.getImg_file_upload_name();

		// 2 리스트가 있는지 검사
		boolean yesList = fileList != null && fileList.size() > 0;

		// 3 리스트가 있는지 검사해 flag setting
		if (yesList) {
			// 4 여러개의 파일중 0번 파일을 대표파일로 지정
			imageVO.setImg_file(imageVO.getImg_file_upload_name().get(0));
		}

		// 5 tbl_gallery에 본문 insert
		int ret = imDao.insert(imageVO);
		long img_p_code = imageVO.getImg_seq();

		// 6 파일 이름들을 저장하기 위해 리스트를 생성
		List<ImageFilesVO> files = new ArrayList<ImageFilesVO>();

		// 7 리스트가 있는지 재검사
		if (yesList) {
			// 8 파일 이름을 DB에 저장하기 위한 리스트를 작성
			for (String fileName : fileList) {
				files.add(ImageFilesVO.builder().img_file_p_code(img_p_code).img_file_upload_name(fileName)
						.img_file_origin_name(fileName.substring(36)).build());
			}

			// 9 파일정보를 tbl_images에 bulk insert
			ifService.imageFileInsert(files, img_p_code);
		}

		log.debug(imageVO.toString());
		return ret;
	}

	public int insert(ImageVO imageVO, String dumy) {

		List<String> fileList = imageVO.getImg_file_upload_name();

		// 여러개의 파일중 0번 파일을 대표파일로 업로드
		if (fileList != null && fileList.size() > 0) {
			imageVO.setImg_file(imageVO.getImg_file_upload_name().get(0));
		}

		// 1 tbl_gallery에 데이터 insert
		int ret = imDao.insert(imageVO);

		// 2 파일이름들을 ImageFilesVO의 리스트에 생성
		// ImageFilesVO의 img_file_p_code 칼럼에
		// tbl_gallery의 seq값을 추가해서 list 생성
		List<ImageFilesVO> files = new ArrayList<ImageFilesVO>();

		if (fileList != null) {
			for (String fileName : fileList) {
				files.add(ImageFilesVO.builder().img_file_upload_name(fileName).img_file_p_code(imageVO.getImg_seq())
						.build());
			}

			// 3. 파일정보를 tbl_images에 insert
			ifService.imageFileInsert(files, imageVO.getImg_seq());

		}

		log.debug(imageVO.toString());
		return ret;
	}

	public ImageVO findBySeq(String img_seq) {

		ImageVO imgVO = imDao.findBySeq(img_seq);
		log.debug(imgVO.toString());
		return imgVO;
	}

	public int update(ImageVO imageVO) {

		long img_seq = imageVO.getImg_seq();
		String img_file = imageVO.getImg_file();
		ImageVO imgVO = imDao.findBySeqAndFile(img_seq, img_file);
		if (imgVO == null) {
			ImageVO oldImageVO = imDao.findBySeq(img_seq + "");
				if (oldImageVO.getImg_file() != null) {
				fService.file_delete(oldImageVO.getImg_file());
			}
		}
		List<String> fileNames = imageVO.getImg_file_upload_name();
		if (fileNames != null && fileNames.size() > 0) {
			List<ImageFilesVO> files = new ArrayList<ImageFilesVO>();
			for (String fileName : fileNames) {
				ImageFilesVO vo = ImageFilesVO.builder().img_file_origin_name(fileName.substring(36))
						.img_file_upload_name(fileName).build();
				files.add(vo);
			}
			ifService.imageFileInsert(files, imageVO.getImg_seq());
			// imageVO.setImg_file(fileNames.get(0));
		}

		int ret = imDao.update(imageVO);

		return ret;
	}

	public int delete(String img_seq) {

		ImageVO imgVO = imDao.findBySeq(img_seq);
		if (imgVO.getImg_file() != null) {
			fService.file_delete(imgVO.getImg_file());
		}
		int ret = imDao.delete(img_seq);

		return ret;
	}

	public List<ImageFilesVO> files_up(MultipartHttpServletRequest mFiles) {
		List<ImageFilesVO> fileNames = new ArrayList<ImageFilesVO>();

		for (MultipartFile file : mFiles.getFiles("files")) {

			ImageFilesVO imVO = ImageFilesVO.builder().img_file_origin_name(file.getOriginalFilename())
					.img_file_upload_name(fService.file_up(file)).build();

			fileNames.add(imVO);
		}

		return fileNames;
	}
}
