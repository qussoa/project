#IMAGE GALLERY PROJECT
* 2020-01-03
### WYSWYG(WHAT YOU SEE WHAT YOU GET) EDITOR
* SUMMERNOTE : https://summernote.org/

* textarea에 id값을 설정하고 id에 jquery를 이용 속성 설정시 간편하게 WYSWYG 방식으로
문서 작성 가능

### drag & drop으로 파일 올리기
1. drag and drop 수행할 박스를 만들기
2. jquery drag over drop event 설정
3. e.orignal.Evant.DataTranfer로부터 files 객체 추출
4. files 객체에서 [0] 파일 객체를 추출

5. ajax를 통해 서버로 파일을 업로드 수행
6. 파일 이름등을 response로 받기
7. form img_file input box에 저장
8. 내용을 form post로 업로드하고 DB에 저장

### Drag and Drop으로 여러개 파일 올리기
*1~3까지는 single file upload와 동일
4. files 객체에 담긴 모든 file 객체를 formData에 append()

5. ajax를 사용해서 서버로 업로드를 수행하고
6. 컨트롤러는 수신된 파일들을 서버에 저장하고 
7. 저장된 파일이름을 리스트로 생성하고
8. 생성된 파일이름 리스트와 리스트를 표현할 jsp를 rendering하여 다시 return 하고
9. ajax success 코드에서는 return 받은 html코드를 
10. 리스트를 표현할 box에 보인다

#### 리스트를 만들 때 
* hidden으로 파일리스트를 담을 input box를 만들고 
* 각각의 파일이름을 input box의 value에 추가해준다

#### 저장 시
* 컨트롤러에서 본문(text)과 함께 hidden input box에 담긴 파일이름을 수신하는데
* String[] mFile : 문자열 배열로 수신하면 된다