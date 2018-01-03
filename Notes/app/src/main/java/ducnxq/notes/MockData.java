package ducnxq.notes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quy Duc on 1/2/2018.
 */

public class MockData {
    private static final List<MyNote> noteList = new ArrayList<>();

    public static List<MyNote> getNoteList(){
        return noteList;
    }

    /**
     * Hàm để thêm một đối tượng MyNote vào noteList
     * @see MockData#noteList
     * @param myNote đối tượng cần thêm
     * @return true là thành công, false là thất bại
     */
    public static boolean addNewNote(MyNote myNote){
        return noteList.add(myNote);
    }

    /**
     * Hàm để remove đối tượng MyNote ra khỏi list theo id
     * @param idNote id của Note
     * @return true là thành công, false là thất bại
     */
    public static boolean removeNote(String idNote){
        for (MyNote myNote : noteList) {
            if (myNote.getId().equalsIgnoreCase(idNote)){
                noteList.remove(myNote);
                return true;
            }
        }
        return false;
    }
}
