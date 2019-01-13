package godock.edenhighway.sujae.com.godock;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageSliderAdapter extends PagerAdapter {
    private int[] images = {R.drawable.jocbal,
            R.drawable.bossam,
            R.drawable.yang};
    private LayoutInflater inflater;
    private Context context;
    public ImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        try{
            inflater = (LayoutInflater)context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.slider, container, false);
            ImageView imageView = v.findViewById(R.id.imageView);
            TextView textView = v.findViewById(R.id.textView);
            imageView.setImageResource(images[position]);
            String text = (position + 1) + "번째 이미지";
            textView.setText(text);
            container.addView(v);
            return v;
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
