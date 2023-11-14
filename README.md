# kotlin-dday-counter
[Kotlin] 디데이를 세는 `안드로이드` 앱

![두근두근](https://github.com/1three/kotlin-dday-counter/assets/94810322/d390d211-4595-4f1b-9a09-2ac6a08d984f)

<br>

## ⏰ 배운 점

### 🧮 시간 계산하기

_Kotlin_ 에서는 **날짜를 어떻게 계산**하는지 궁금했습니다.<br>
직접 찾아보고 사용해보니, 이전에 `Java`에서 사용했던 메서드와 같았습니다...!

```
- Calendar.getInstance()
  현재 시스템의 날짜와 시간을 나타내는 Calendar 객체를 반환한다.

예를 들어, Calendar.getInstance()를 호출하여 현재 날짜와 시간을 가져온 뒤
         get(Calendar.YEAR)와 같은 메서드를 사용하여 연도를 조회하거나
         set(Calendar.MONTH, 5)와 같은 메서드를 사용하여 월을 설정할 수 있다.

- TimeUnit.MILLISECONDS.toDays()
  밀리초 단위의 시간 차이를 일 단위로 변환해준다.
```

<br>

```Kotlin
val calendar_start = Calendar.getInstance()
val calendar_end = Calendar.getInstance()

...

calendar_start.set(year, month + 1, dayOfMonth)
calendar_end.set(year, month + 1, dayOfMonth)

...

val calcDate =
    TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

val dDayText = findViewById<TextView>(R.id.dDayTextView)

if (calcDate.toInt() == 0) {
    dDayText.text = "D-Day"
} else if (calcDate.toInt() > 0) {
    dDayText.text = "D-${calcDate}"
} else {
    dDayText.text = "시작 일자를 변경해 주세요."
}
```
