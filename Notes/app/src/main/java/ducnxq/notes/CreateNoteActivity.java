package ducnxq.notes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CreateNoteActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_save) {
            if (fragment instanceof CreateNoteActivityFragment){
                CreateNoteActivityFragment createNoteActivityFragment = (CreateNoteActivityFragment) fragment;
                MyNote newNote = createNoteActivityFragment.getNewMyNote();
                if (newNote != null){
                    MockData.addNewNote(newNote);
                    finish();
                }
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
