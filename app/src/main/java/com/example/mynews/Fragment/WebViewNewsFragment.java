package com.example.mynews.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynews.Adapter.NewsAdapter;
import com.example.mynews.R;

public class WebViewNewsFragment extends Fragment implements NewsAdapter.Listener {
    protected NewsAdapter newsAdapter;
    protected RecyclerView recyclerView;

    // Declare callback
    private OnWebClickedListener callbackUrl;


    public WebViewNewsFragment() {
        // Required empty public constructor
    }

    public static WebViewNewsFragment newInstance(String param1, String param2) {
        WebViewNewsFragment fragment = new WebViewNewsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get layout of this fragment
        View view = inflater.inflate(R.layout.fragment_web_view_news, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClickItem(int position) {
        String url = newsAdapter.getPosition(position).getImageUrl();

    }

    // Declare our interface that will be implemented by any container activity
    public interface OnWebClickedListener {
        void onWebClicked(int position, String url);
    }
    // Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            // Parent activity will automatically subscribe to callback
            callbackUrl = (OnWebClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnWebClickedListener");
        }
    }

}