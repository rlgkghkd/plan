


# plan
## 개요
일정을 저장하고 관리할 수 있으며, 일정에 댓글, 댓글에 대댓글을 작성할 수 있습니다.<br>
댓글은 일정을, 대댓글은 일정과 댓글을 참조합니다.

일정의 경우 전체 목록을 조회할 수 있으며<br>일정 단건 조회시 일정의 상세내역과 함께, 일정에 달린 모든 댓글, 대댓글을 표시합니다.<br>
일정의 댓글 수는 댓글, 대댓글의 갯수를 합친 결과입니다.

댓글의 경우 단건 조회만 가능하며, 조회시 댓글에 달린 모든 대댓글을 표시합니다.

대댓글 조회는 단건만 가능하며, 조회시 대댓글을 단 댓글과 대댓글을 함께 표시합니다.

모든 종류의 게시글은 작성일을 기준으로 오름차순으로 정렬합니다.

---
모든 일정, 댓글, 대댓글은 작성 시 아이디와 비밀번호가 필요하며, 수정, 삭제시에는 비밀번호만 검사합니다.

---
- 스케줄 작성
  
| 기능 | 메서드 | URL                                                                                          | Request Body | Response Body                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Error Response | Response |
| --- | --- |----------------------------------------------------------------------------------------------| --- |-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| --- | --- |
| 글 남기기 | POST | /api/plan                                                                                    | {<br>"writer_id":"String",<br> "password":"String",<br>"title":"String"<br>"content":"String"<br>} | {<br> "plan_id":Long,<br>"writer_Id":"String",<br> "title":"String",<br>"content":"String",<br>"created_at:":"Date"<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | • 400 Bad_Request: 잘못된 비밀번호 양식 | • 201 created |
| 글 삭제 | DELETE | /api/plan/{plan_id}                                                                          | {<br>"password":"String"<br>} | 삭제되었습니다.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | • 401 Unauthorized: 작성자 불일치<br>• 401 Unauthorized: 비밀번호 불일치 | • 200 ok |
| 글 수정 | PATCH | /api/plan/{plan_id}                                                                          | {<br>"writer_id":"String",<br>"password":"String",<br>"title":"String",<br>"content":"String"<br>} | {<br>"plan_id":Long,<br>"writer_Id":"String",<br>"title":"String",<br>"content":"String"<br>"updated_at":":"Date"<br>}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | • 401 Unauthorized: 작성자 불일치<br>• 401 Unauthorized: 비밀번호 불일치 | • 200 ok |
| 글 목록 조회 | GET | /api/plan?index=int & writerId=writerId & title=title & before=yyyy-mm-dd & after=yyyy-mm-dd | - | [<br>&nbsp;{<br>&nbsp;"plan_id":Long,<br>&nbsp;"writer_Id":"String",<br>&nbsp;"title":"String",<br>&nbsp;"writed_at":"Date",<br>&nbsp;"updated_at:":"Date",<br>&nbsp;"comments_count":Long<br>&nbsp;} <br>&nbsp;...<br>]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | • 400 Bad_Request: 잘못된 파라미터 양식<br>• 401 Unauthorized: 작성자 불일치<br>• 401 Unauthorized: 비밀번호 불일치<br>• 404 Not_Fount: 검색 결과 없음 | • 200 ok |
| 글 조회 | GET | /api/plan/{plan_id}                                                                          | - | {<br>&nbsp;"plan_Id":Long,<br>&nbsp;"writer_Id":"String",<br>&nbsp;"content":"String",<br>&nbsp;"created_at":":"Date",<br>&nbsp;"updated_at:":"Date",<br>&nbsp;"comments_count":Long,<br>&nbsp;"comments": <br>&nbsp;[<br>&nbsp;&nbsp;{<br>&nbsp;&nbsp;"writer_Id":"String", <br>&nbsp;&nbsp;"comment":"String", <br>&nbsp;&nbsp;"created_at":"Date", <br>&nbsp;&nbsp;"updated_at:":"Date". <br>&nbsp;&nbsp;"replies":<br>&nbsp;&nbsp;[<br>&nbsp;&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;"writer_Id":"String", <br>&nbsp;&nbsp;&nbsp;"reply":"String", <br>&nbsp;&nbsp;&nbsp;"created_at":":"Date", <br>&nbsp;&nbsp;&nbsp;"updated_at:":"Date" <br>&nbsp;&nbsp;&nbsp;}<br>&nbsp;&nbsp;...<br>&nbsp;&nbsp;] <br>&nbsp;}<br>&nbsp;...<br>} | • 404 Not_Fount: 해당 글 없음 | • 200 ok |


- 댓글 작성
    
    
| 기능 | 메서드 | URL | Request Body                                                                      | Response Body | Error Response | Response |
| --- | --- | --- |-----------------------------------------------------------------------------------| --- | --- | --- |
| 댓글 남기기 | POST | /api/plan/{plan_id} <br>/comment | { <br>"writer_Id":"String", <br>"password":"String", <br>"comment":"String" <br>}    | { <br>"plan_id":Long, <br>"comment_Id":Long, <br>"writer_Id":"String", <br>"comment":"String", <br>"created_at":"Date" <br>} | • 400 Bad Request: 잘못된 비밀번호 양식 | • 201 created |
| 댓글 삭제 | DELETE | /api/plan/{plan_id} <br>/comment/{comment_id} | { <br>"writer_Id":"String", <br> "password":"String" <br>}                        | 삭제되었습니다. | • 401 Unauthorized: 작성자 불일치<br>• 401 Unauthorized: 비밀번호 불일치 | • 200 ok |
| 댓글 수정 | PATCH | /api/plan/plan_id} <br>/comment/{comment_id} | { <br>"writer_Id":"String", <br>"password":"String", <br>"comment":"String" <br>} | { <br> "plan_id":Long, <br>"comment_Id":Long, <br>"writer_Id":"String", <br>"comment":"String", <br>"created_at":"Date", <br> "updated_at:":"Date" <br>} | • 401 Unauthorized: 작성자 불일치 <br>• 401 Unauthorized: 비밀번호 불일치 <br> • 404 Not_Fount: 해당 댓글 없음 | • 200 ok |
| 댓글 조회 | GET | /api/plan/plan_id} <br>/comment/{comment_id} | -                                                                                 | { <br>"plan_id":Long, <br>"comment_Id":Long, <br>"writer_Id":"String", <br> "comment":"String", <br>"created_at":"Date", <br>"updated_at:":"Date". <br>"replies":<br>[<br>&nbsp;&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;"writer_Id":"String", <br>&nbsp;&nbsp;&nbsp;"reply":"String", <br>&nbsp;&nbsp;&nbsp;"created_at":":"Date", <br>&nbsp;&nbsp;&nbsp;"updated_at:":"Date" <br>&nbsp;&nbsp;&nbsp;}<br>&nbsp;&nbsp;...<br>&nbsp;&nbsp;] <br>} | • 404 Not_Fount: 해당 댓글 없음 | • 200 ok |
- 대댓글 작성
    
    
| 기능 | 메서드 | URL | Request Body                                                                       | Response Body                                                                                                                                                                                                                                                                                          | Error Response | Response |
| --- | --- | --- |------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| --- | --- |
| 대댓글 남기기 | POST | /api/plan/{plan_id} <br>/comment/{comment_id} <br>/reply | { <br>"writer_Id":"String", <br>"password":"String", <br> "reply":"String" <br>}      | { <br> "plan_id":Long, <br>"comment_Id":Long, <br> "reply_Id":Long, <br> "writer_Id":"String", <br> "reply":"String", <br>"created_at":":"Date" <br> }                                                                                                                                                 | • 400 Bad Request: 잘못된 비밀번호 양식 | • 201 created |
| 대댓글 삭제 | DELETE | /api/plan/{plan_id} <br>/comment/{comment_id} <br>/reply/{reply_id} | { <br>"writer_Id":"String", <br>"password":"String" <br>}                          | 삭제되었습니다.                                                                                                                                                                                                                                                                                               | • 401 Unauthorized: 작성자 불일치 <br>• 401 Unauthorized: 비밀번호 불일치 | • 200 ok |
| 대댓글 수정 | PATCH | /api/plan/{plan_id} <br>/comment/{comment_id} <br>/reply/{reply_id} | { <br> "writer_Id":"String", <br> "password":"String", <br>"reply":"String" <br> } | { <br>"plan_id":Long, <br>"comment_id":Long, <br>"reply_id":Long, <br>"writer_Id":"String", <br>"reply":"String", <br>"created_at":":"Date", <br> "updated_at:":"Date" <br>}                                                                                                                           | • 401 Unauthorized: 작성자 불일치 <br>• 401 Unauthorized: 비밀번호 불일치 <br> • 404 Not_Fount: 해당 대댓글 없음 | • 200 ok |
| 대댓글 조회 | GET | /api/plan/{plan_id} <br>/comment/{comment_id <br>}/reply/{reply_id} | -                                                                                  | {<br>"writer_Id":"String", <br> "comment":"String", <br>"created_at":"Date", <br>"updated_at:":"Date". <br>"reply":<br>{ <br>"plan_id":Long, <br> "comment_id":Long, <br> "reply_id":Long, <br>"writer_Id":"String", <br>"reply":"String", <br>"created_at":":"Date", <br>"updated_at:":"Date" <br>}<br>} | • 404 Not_Fount: 해당 대댓글 없음 | • 200 ok |

### ERD 
![image](https://github.com/user-attachments/assets/15c2fcea-47b7-471f-81f7-d37f1594187f)

### 동작 캡쳐
---
#### plan
![image](https://github.com/user-attachments/assets/d35e7685-9b0d-4dc0-8073-b144b3e956f2)
![image](https://github.com/user-attachments/assets/3123e3c2-da19-4a73-823c-ee62d787d6ba)
![image](https://github.com/user-attachments/assets/3515f1c1-8108-4fd2-981d-0f1aba41a5de)
![image](https://github.com/user-attachments/assets/973ca44c-2865-4e11-8e5c-81c1900cf238)
![image](https://github.com/user-attachments/assets/e3404217-b571-4262-8bdf-0c181d1a3b0c)

---

#### comment(댓글)
![image](https://github.com/user-attachments/assets/62a5d11d-52d4-4d38-af9d-cb5c5106ef0d)
![image](https://github.com/user-attachments/assets/f67edbe3-89f3-4133-aef2-0e2716ff4e6f)
![image](https://github.com/user-attachments/assets/e196e771-2df0-44a4-b51d-68deb1d1dc43)
![image](https://github.com/user-attachments/assets/e8264d31-4958-4b0b-b2f4-4851281a4c50)

---

#### reply(대댓글)
![image](https://github.com/user-attachments/assets/6ca6ac2b-213f-47c5-9fe4-493e0fccb0a3)
![image](https://github.com/user-attachments/assets/42efdf26-ac0c-475a-bc8a-5dcd67feb1df)
![image](https://github.com/user-attachments/assets/4611535b-b64a-4771-b1ad-4cd5fa9f5254)
![image](https://github.com/user-attachments/assets/c0fdab88-a354-48ac-9cc1-849941efabf6)

---

## 스택
![image](https://github.com/user-attachments/assets/c1c8d3e9-42ef-418a-a945-4a1f519a893a)
![image](https://github.com/user-attachments/assets/2683a873-7199-4dde-8aca-f68dfdce75bb)
![image](https://github.com/user-attachments/assets/add58077-426b-4719-811a-9a605b4a5667)
![image](https://github.com/user-attachments/assets/ee9b7267-5458-4ac7-b6bf-b388007f816c)
![image](https://github.com/user-attachments/assets/73d52a7c-fbd9-45fe-9be9-68fd01351824)

