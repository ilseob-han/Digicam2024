package GUI;

public class FriendshipManager {
    private FriendshipDAO friendshipDAO;

    public FriendshipManager() {
        this.friendshipDAO = new FriendshipDAO();
    }

    public void addFriendship(String userId1, String userId2) {
        try {
            friendshipDAO.addFriendship(userId1, userId2);
            System.out.println("친구 추가 성공: " + userId1 + "와(과) " + userId2);
        } catch (Exception e) {
            System.out.println("친구 추가 실패");
            e.printStackTrace();
        }
    }

    public void deleteFriendship(String userId1, String userId2) {
        // 여기에 친구 삭제 로직을 구현합니다. 예를 들면:
        // friendshipDAO.deleteFriendship(userId1, userId2);
        System.out.println("친구 삭제 기능은 아직 구현되지 않았습니다.");
    }
}