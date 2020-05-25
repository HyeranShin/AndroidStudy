package com.hyeran.androidstudy.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hyeran.androidstudy.R
import kotlinx.android.synthetic.main.activity_heartsignal.*

class HeartSignalActivity : AppCompatActivity() {

    private val hearSignalItemAdapter = HearSignalItemAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heartsignal)

        rv_heartsignal.adapter = hearSignalItemAdapter
        loadDataList()
    }

    private fun loadDataList() {
        val dataList = mutableListOf<HearSignalData>()
        with(dataList) {
            add(
                HearSignalData(
                    profile = "https://w.namu.la/s/5e617fc231531ebd82cef302d63ee72ac48df000d0d338f93e03bd99e44b1f55791954bfe9dc1be6957f56bb9211dd24cbfeb593869985f451de147e9f375217bc0a3d733a186c5d9ea96bd1d2315d4d45b43fe5768340fa2fc5c18cb4fb91c6",
                    name = "천인우",
                    sns = "북극곰"
                )
            )
            add(
                HearSignalData(
                    profile = "https://ww.namu.la/s/b34439bcd31900749935d0b90cb4e4b76f9ef55e4c970e98080b1e3866ab12be18b6e711318d06bdcce772c81e4b6050351c842c1988f3b4d2a3d05f27dfcc04a77d535150f04d13e4695deddaa2eb1dfda61dc7e7e8b3fc51dfbcfbcc551ab4",
                    name = "정의동",
                    sns = "범고래"
                )
            )
            add(
                HearSignalData(
                    profile = "https://w.namu.la/s/6581644ab4298f289261c915ff25b6209069d9507b50a273e00e73d0ec798dff51cf70c554df4bf21e19c315982d07977e17aed3ac0b5d21e7a2e8df68f86c06f2584232399b5544f1fe396c6ce3a3eca6adebc93b611deb34ea484d67bb086f",
                    name = "이가흔",
                    sns = "고양이"
                )
            )
            add(
                HearSignalData(
                    profile = "https://ww.namu.la/s/cb69490afaedcd7c04348039c05db7c7a0371e5bde63c605fc87b75c191bec23a315f1bd3ea534b54d75cc32cd1cd2ccaac7cb328a3ebbb5385eed7f073554b6825213b64875f4ec4fab6ebae76577c094a31e4f8550df0e56fd2798417f9d6f",
                    name = "임한결",
                    sns = "사슴"
                )
            )
            add(
                HearSignalData(
                    profile = "https://ww.namu.la/s/f65f7a244ad10b17a518069d1c8f53eadfae8f1e4de2177ed0cb91e0c5d2275db31bd66bbf35bb687d946ed7df4282d919516842cd3895fe2df71a8b7f805c151c38782fda74c07beb911dc848c1deabd7d8d1cbea548b50c4a6b3bf1bb5aebc",
                    name = "서민재",
                    sns = "토끼"
                )
            )
            add(
                HearSignalData(
                    profile = "https://w.namu.la/s/af1f690ca466a0fe22f75a131b8a5ebb3ac96c93cfc032959667d398f69d2be698b391f38f557cadf07a21cb27e9aae761755327efeb7a85e480cc879ebfba26d6d59fe573431dc4501ca256b2e9cb11305c7ed5f52a515e88c541047b7138e5",
                    name = "박지현",
                    sns = "병아리"
                )
            )
            add(
                HearSignalData(
                    profile = "https://w.namu.la/s/86fd6a1f1881815941fdbb735e1492cf41ba2195e9fa3f96ea2314d1d160c6c8e3428d78df5368a2504bf26069c7967fd6874eb0855e4069e473e8a2a93320286dc354b79c8038d67327b4e069e0bd8b43123bdd03c0988f2761bbe77386f69d",
                    name = "김강열",
                    sns = "사자"
                )
            )
            add(
                HearSignalData(
                    profile = "https://w.namu.la/s/6915683c31bb8ecd1e939edcf4d37e754a57215da0ad95d2fe04dd417ee7927ba27c2b242148fb661c0cb3d7189fbb195e2b47570c6664e198aac117326dccf383a8b04c81fd8a5651793b96c67be3697d6c174d0d2338654add21f163b32723",
                    name = "천안나",
                    sns = "강아지"
                )
            )
        }

        hearSignalItemAdapter.dataList = dataList
        hearSignalItemAdapter.notifyDataSetChanged()
    }
}
