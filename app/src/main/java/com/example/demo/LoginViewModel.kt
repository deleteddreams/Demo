import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.LoginRepository
import com.example.demo.LoginRequest
import com.example.demo.LoginResponse
import com.example.demo.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val msg = SingleLiveEvent<String>()
    fun login(loginRequest: LoginRequest) {
        val response = repository.login(loginRequest)
        response?.enqueue(object: Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.body()?.access_token != null){
                    //mAction.setValue(Action(Action.SHOW_WELCOME));
                    msg.value = "success"
                } else {
                    //mAction.setValue(Action(Action.SHOW_INVALID_PASSWARD_OR_LOGIN));
                    msg.value = "fail"
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                msg.value = "fail"
                errorMessage.postValue(t.message)
            }

        })
    }
}