package ducnxq.notes;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ducnxq.notes.adapter.NotesAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView rcvListNote;
    private NotesAdapter adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvListNote = view.findViewById(R.id.rcvListNote);
        rcvListNote.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NotesAdapter(getActivity(),MockData.getNoteList());
        rcvListNote.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        //Reload lại dữ liệu khi quay lại activity này
        adapter.notifyDataSetChanged();
    }
}
