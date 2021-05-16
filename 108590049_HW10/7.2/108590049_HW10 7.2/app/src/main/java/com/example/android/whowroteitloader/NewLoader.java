package com.example.android.whowroteitloader;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class NewLoader extends AsyncTaskLoader<String> {

    private String mQueryString;
    private String mTransferProtocol;
    private Context mContext;

    public NewLoader(Context context, String queryString, String transferProtocol) {
        super(context);
        mQueryString = queryString;
        mTransferProtocol = transferProtocol;
        mContext = context;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getSource(mContext, mQueryString, mTransferProtocol);
    }

}