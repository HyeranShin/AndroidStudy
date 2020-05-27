# Retrofit
### Server와 Client
####  사용자 → Client
- **사용자의 Action**
- 사용자의 클릭 이벤트 감지 및 해당 로직 처리
- 사용자에게 화면을 그려줌
- 로딩 화면을 보여줌
- 받은 데이터를 사용자가 보기 좋게 화면에 적절히 그려줌
#### Client → Server
- **서버에게 데이터 요청 / 전달**
- ex) 로그인을 위해 유저가 입력한 아이디, 비밀번호 데이터 전달
- ex) 인스타 새로운 소식 받아오도록 요청
#### Server → Client
- **서버로부터 응답 / 에러를 받음**
- ex) 로그인 성공 / 실패 여부
- ex) 인스타 피드 데이터
#### Client → 사용자
- **받은 데이터를 화면에 그려줌**
- ex) 로그인에 성공했습니다! 토스트
- ex) 인스타 새로운 사진
### Json
- 서버와 클라이언트가 대화를 나누는 언어
- 서버와 데이터 요청 및 수신이 이루어지는 언어
```json
[
  {
    "이름": "교촌치킨",
    "대표메뉴": ["허니콤보", "반반콤보"],
    "평점": 4.5
  },
  {
    "이름": "굽네치킨",
    "대표메뉴": ["고추바사삭", "볼케이노"],
    "평점": 4.5
  }
]
```
#### 장점
- **텍스트**로 이루어져 있어 기계, 사람 모두 이해하기 쉬움
- 프로그래밍 **언어와 플랫폼에 독립적** → 서로 다른 시스템간에 객체를 교환하기 좋음
#### 기본 자료형
- Number(정수, 실수) *8진수나 16진수는 지원 X
- 문자열
- Boolean(true / false)
- 배열
  - [] 대괄호로 정의
  - 아무 자료형이나 들어갈 수 있음
- 객체
  - {} 중괄호로 정의
  - 키 값은 문자열
  - 키 값을 이용해서 실제 값에 접근 가능
- Null
### 동기와 비동기
#### 동기(Synchronous Processing Model)
- **직렬적**으로 태스크 수행
- 어떤 작업이 수행 중이면 **다음 작업은 대기**
- ex) 서버에서 데이터를 가져와 화면에 표시하는 작업을 수행할 때, 서버에 데이터를 요청하고 데이터가 응답될 때까지 **이후 태스크들은 블로킹(작업 중단)**
#### 비동기(Asynchronous Processing Model)
- **병렬적**으로 태스크 수행
- 어떤 작업이 수행 중이더라도 **다음 태스크를 실행**
- ex) 서버에서 데이터를 가져와 화면에 표시하는 작업을 수행할 때, 서버에 데이터를 요청하고 데이터가 응답될 때까지 **대기하지 않고 즉시 다음 태스크 수행** <br/>→ 이후 서버로부터 데이터가 응답되면 이벤트 발생
### Restful API
- REpresentational State Transfer : HTTP 장점을 최대한 활용할 수 있는 아키텍처
- **서버에 존재하는 데이터에 접근하기 위한 대표적인 규칙**
1. 자원(Resource) - URI(http://서버 이름/자원 식별)
2. 행위(Verb) - HTTP Method
   - GET : 데이터 자체 단순 요구
   - POST : 데이터 제출, 서버의 상태 변화
   - PUT : 데이터 변경
   - DELETE : 데이터 삭제
### Retrofit의 활용
- 공식 문서: http://devflow.github.io/retrofit-kr/
#### 0. 서버와 필요한 데이터 논의
#### 1. 라이브러리 추가
```groovy
//Retrofit 라이브러리 : https://github.com/square/retrofit 
implementation 'com.squareup.retrofit2:retrofit:2.6.2' 
//Retrofit 라이브러리 응답으로 가짜 객체를 만들기 위해 
implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'

//객체 시리얼라이즈를 위한 Gson 라이브러리 : https://github.com/google/gson
implementation 'com.google.code.gson:gson:2.8.6'
//Retrofit 에서 Gson 을 사용하기 위한 라이브러리 
implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
```
manifest
```xml
<uses-permission android:name="android.permission.INTERNET" />

<application
    android:usesCleartextTraffic="true" <!--http 허용-->
```
#### 2. API 문서 보고 Request / Response 객체 설계
```kotlin
data class LoginResponseDto(
    val status: Int,
    val success: Boolean,
    val message: String,
    @SerializaedName("data") //서버에서 지어준 이름 지정해주면 원하는 변수명으로 변경 가능
    val responseData: SomeData?
    //필요없는 데이터는 변수 만들지 않아도됨 
)
```
#### 3. Retrofit Interface 설계
```kotlin
interface RequestInterface {
    @GET("/group/{id}/users")
    fun groupList(@Path("id") groupId: Int, @Query("sort") sort: String) : Call<List<User>>
    
    @Headers("Content-Type: application/json") //정적 헤더
    @Get("/user")           //동적 헤더
    fun getUser(@Header("Authorization") authorization: String) : Call<User>
    
    @POST("/users/new")
    fun createUser(@Body user: User) : Call<User>
    
    @Multipart
    @PUT("/user/photo")
    fun updateUser(@Part("photo") photo: RequestBody) : Call<User>
}
```
#### 4. Retrofit Interface 실제 구현체 만들기
```kotlin
//싱글톤. 코드 아무데서나 접근 가능, 객체는 단 하나만 생성
object RequestToServer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://~")
        .addConverterFactory(GsonConverterFactory.create()) //Retrofit으로 받아온 json 데이터를 데이터 클래스로 변환하기 쉽게
        .build()
        
    //retrofit 객체의 create 호출. Interface 클래스 타입을 넘겨 실제 구현체를 만들어줌
    val service: RequestInterface = retrofit.create(RequestInterface::class.java)
}
```
#### 5. Callback 등록하며 통신 요청
```kotlin
private val requestToServer = RequestToServer

private fun setRetrofit() {
    requestToServer.createUser(
        User(
            name="hyeran",
            age=24
        )   //Request 정보 전달 → Call 타입 리턴
    ).enqueue(object: Callback<ResponseDto> { //실제 서버 통신을 비동기적으로 요청
        override fun onFailure(call: Call<ResponseDto>, t: Throwable) {
            //비동기 통신 중 발생한 에러
        }
        
        override fun onResponse( //비동기 요청 후 응답 받았을 때 수행할 행동
            call: Call<ResponseDto>,
            response: Response<ResponseDto>
        ) {
            //통신 성공
            if(response.isSuccessful) { //statusCode가 200~300
                
            } else {
            
            }
        }
    })
}
```