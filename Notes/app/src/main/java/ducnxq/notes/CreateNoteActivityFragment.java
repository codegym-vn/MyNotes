package ducnxq.notes;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.UUID;

/**
 * A placeholder fragment containing a simple view.
 */
public class CreateNoteActivityFragment extends Fragment {

    private EditText etTitle;
    private EditText etDescription;

    public CreateNoteActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etTitle = view.findViewById(R.id.etTitle);
        etDescription = view.findViewById(R.id.etDescription);
    }

    /**
     * Hàm để lấy ra đối tượng MyNote chứa thông tin của người dùng nhập vào
     * @return đối tượng MyNote
     */
    public MyNote getNewMyNote() {
        if (!validateData()){
            return null;
        }
        MyNote myNote = new MyNote();
        myNote.setId(UUID.randomUUID().toString());
        myNote.setTitle(etTitle.getText().toString());
        myNote.setDescription(etDescription.getText().toString());
        myNote.setCreatedDate(new Date());
        return myNote;
    }

    /**
     * Hàm validate dữ liệu. Người dùng phải bắt buộc nhập Ghi chú và tiêu đề
     * @return
     */
    private boolean validateData() {
        if (TextUtils.isEmpty(etDescription.getText().toString())){
            Toast.makeText(getActivity(), "Vui lòng nhập ghi chú", Toast.LENGTH_SHORT)
                   .show();
            return false;
        }
        if (TextUtils.isEmpty(etTitle.getText().toString())){
            Toast.makeText(getActivity(), "Vui lòng nhập tiêu đề", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
