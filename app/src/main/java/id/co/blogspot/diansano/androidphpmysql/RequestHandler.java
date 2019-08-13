package id.co.blogspot.diansano.androidphpmysql;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

//this class is for singleton
public class RequestHandler {

    private static RequestHandler mInstance;
    private RequestQueue mRequestQueueu;

    private static Context mCtx;

    private RequestHandler(Context context) {
        mCtx = context;
        mRequestQueueu = getRequestQueue();
    }

    public static synchronized RequestHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RequestHandler(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueueu == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueueu = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueueu;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
