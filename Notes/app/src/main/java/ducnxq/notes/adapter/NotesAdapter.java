package ducnxq.notes.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import ducnxq.notes.MockData;
import ducnxq.notes.MyNote;
import ducnxq.notes.R;

/**
 * Created by Quy Duc on 12/31/2017.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private Context context;
    private List<MyNote> listData;

    public NotesAdapter(Context context, List<MyNote> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final MyNote noteItem = listData.get(position);
        holder.tvTitle.setText(noteItem.getTitle());
        holder.tvDescription.setText(noteItem.getDescription());
        holder.tvDate.setText("Đã tạo :" + formatDateToDisplay(noteItem.getCreatedDate()));
        holder.ivDetele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogToDetele(noteItem, position);
            }
        });

    }

    /**
     * Hàm khởi tạo AlertDialog và hiển thị để xác nhận việc xóa ghi chú
     * @param noteItem đối tượng muốn xóa
     * @param position vị trí trong adapter
     */
    private void showDialogToDetele(final MyNote noteItem, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Bạn có muốn xóa ghi chú này?")
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MockData.removeNote(noteItem.getId());
                        notifyItemRemoved(position);
                    }
                })
                .setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        // Create the AlertDialog object and return it
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public String formatDateToDisplay(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        return format.format(date);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle;
        private final TextView tvDescription;
        private final TextView tvDate;
        private final View ivDetele;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivDetele = itemView.findViewById(R.id.ivDetele);
        }
    }

}
