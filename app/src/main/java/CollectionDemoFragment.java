import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mynews.Fragment.FragmentOne;
import com.example.mynews.Fragment.FragmentThree;
import com.example.mynews.Fragment.FragmentTwo;
import com.example.mynews.R;

public class CollectionDemoFragment extends Fragment {


    DemoCollectionAdapter demoCollectionAdapter;
    ViewPager2 viewPager2;


    @Nullable
    @Override
    public View onCreateView
            (@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container,
             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {


        this.demoCollectionAdapter = new DemoCollectionAdapter(this);
        this.viewPager2 = view.findViewById(R.id.view_pager2);
        this.viewPager2.setAdapter(this.demoCollectionAdapter);
    }


}

class DemoCollectionAdapter extends FragmentStateAdapter {
    public DemoCollectionAdapter(final Fragment fragment) {
        super(fragment);
    }


    @NonNull
    @Override
    public Fragment createFragment(final int position) {
        switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
        }
        return new FragmentOne();
    }
        

    @Override
    public int getItemCount() {
        return 100;
    }

    // Instances of this class are fragments representing a single
// object in our collection.
    public class DemoObjectFragment extends Fragment {
        public static final String ARG_OBJECT = "object";

        @Nullable
        @Override
        public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container,
                                 @Nullable final Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_main, container, false);
        }

        @Override
        public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
            final Bundle args = this.getArguments();
            ((TextView) view.findViewById(android.R.id.text1))
                    .setText(Integer.toString(args.getInt(DemoObjectFragment.ARG_OBJECT)));
        }
    }


}

