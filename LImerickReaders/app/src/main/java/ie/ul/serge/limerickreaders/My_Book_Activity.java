package ie.ul.serge.limerickreaders;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SnackbarContentLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;

public class My_Book_Activity extends AppCompatActivity {

    private int mNumberRead;
    private int mTotalRead;
    private Button addBtn;
    private Book mBook;

    private TextView mTitle,mAuthor,mNumberOfPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__book_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTitle = findViewById(R.id.TextView_title);
        mAuthor = findViewById(R.id.TextView_author);
        mNumberOfPages= findViewById(R.id.TextView_pages_read);

        final NumberPicker picker = findViewById(R.id.input_number_picker);
        picker.setMinValue(1);
        picker.setMaxValue(100);

        addBtn = findViewById(R.id.btn_add_pages);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumberRead = picker.getValue();
                Date mDateRead = new Date();
                mTotalRead+=mNumberRead;

               // Toast.makeText(My_Book_Activity.this, mTotalRead +" Pages", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my__book_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_add_new_book:
                editBook();
                //Toast.makeText(this,"menu pressed",Toast.LENGTH_LONG).show();

                return true;
        }




        return super.onOptionsItemSelected(item);
    }

    private void editBook() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.edit_book,null, false);
        builder.setView(view);
        final EditText input_title = view.findViewById(R.id.input_title);
        final EditText input_author = view.findViewById(R.id.input_author);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String bookTitle = input_title.getText().toString();
                String bookAuthor = input_author.getText().toString();
                //TODO : get these ids from Firebase.
                String userID = "user1";
                String bookID = "book1";
               //String bookID = databaseArtists.push().getKey();
                //mTitle.setText(bookTitle);
                Book mBook = new Book(userID,bookID,bookTitle,bookAuthor);

                updateView(mBook);
            }
        });

        builder.create().show();

    }

    private void updateView(Book mBook) {

        mTitle.setText(mBook.getTitle().toString());

    }
}
