package com.example.user.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kakao.auth.ErrorCode;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;

public class MainActivity extends AppCompatActivity {
    SessionCallback callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
    }

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {

            UserManagement.requestMe(new MeResponseCallback() {
                @Override
                public void onSessionClosed(ErrorResult errorResult) {
                    String message = "failed to get user info.msg=" + errorResult;

                    ErrorCode result = ErrorCode.valueOf(errorResult.getErrorCode());

                    if (result == ErrorCode.CLIENT_ERROR_CODE) {
                        finish();
                    } else {

                    }
                }

                @Override
                public void onNotSignedUp() {

                }

                @Override
                public void onSuccess(UserProfile userProfile) {


                    long number = userProfile.getId();
                }
            });

        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {

        }
    }
}
