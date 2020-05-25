# RecyclerView
### 구현 방법
#### Dependency 추가
```gradle
implementation 'androidx.recyclerview:recyclerview:1.1.0'
```
#### 반복될 뷰 만들기 (item_rv.xml)
#### activity layout에 위젯 추가
```xml
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/recyclerview"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:clipToPadding="false"
    app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
    android:orientation="vertical"
    tools:listitem="@layout/item_rv"/>
```
#### Data Class 만들기
데이터 형태
```kotlin
data class ItemData(
    val profile: String,
    val name: String
)
```
#### ViewHolder 만들기
데이터와 뷰 연결
```kotlin
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val iv_profile = itemView.findViewById<ImageView>(R.id.iv_profile_item_rv)
    val tv_name = itemView.findViewById<TextView>(R.id.tv_name_item_rv)

    fun bind(itemData: itemData) {
        Glide.with(itemView).load(itemData.profile).into(iv_profile)
        tv_name.text = itemData.name
    }
}
```
#### Adapter 만들기
데이터 리스트 중 하나 전달
```kotlin
class ItemAdapter(private val context: Context) : RecyclerView.Adapter<ItemViewHolder>() {
    var dataList = mutableListOf<ItemData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}
```
#### Activity에서 RecyclerView와 Adpater 연결
```kotlin
val hearSignalItemAdapter = HearSignalItemAdapter(this)
rv_heartsignal.adapter = hearSignalItemAdapter
hearSignalItemAdapter.dataList = dataList
hearSignalItemAdapter.notifyDataSetChanged()
```