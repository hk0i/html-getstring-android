package onebigfunction.com.richtextstringformat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private static final int SKU_FIVE_CREDITS = 1;
    private static final int SKU_TEN_CREDITS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView fiveCreditsDescriptionTextView
                = (TextView)findViewById(R.id.five_credits_product_description);

        TextView tenCreditsDescriptionTextView
                = (TextView)findViewById(R.id.ten_credits_product_description);

        String description;
        if (fiveCreditsDescriptionTextView != null) {
            description = getString(R.string.product_description_formatted,
                    getString(R.string.five).toUpperCase(),
                    getPrice(SKU_FIVE_CREDITS));
            fiveCreditsDescriptionTextView.setText(Html.fromHtml(description));
        }

        if (tenCreditsDescriptionTextView != null) {
            description = getString(R.string.product_description_formatted,
                    getString(R.string.ten).toUpperCase(),
                    getPrice(SKU_TEN_CREDITS));
            tenCreditsDescriptionTextView.setText(Html.fromHtml(description));
        }

    }

    /**
     * Mock function to get the product price for a given sku. In a real
     * application this would probably be in some other class.
     *
     * @param sku Product sku
     * @return Returns price of the request product sku
     */
    private String getPrice(int sku) {
        String price = "";
        if (sku == SKU_FIVE_CREDITS) {
            // again, realistically you would never return the prices like
            // this. For simplicity's sake this is hard-coded as an example.
            price = "$0.99";
        }
        else if (sku == SKU_TEN_CREDITS) {
            price = "$4.99";
        }

        return price;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
