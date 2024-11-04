package dao;

import java.sql.*;

import vo.Member;

public class MemberDao {
	// CRUD
	public int insert(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
//			String sql = "INSERT INTO tbl_member(id, pw, name) VALUES ('" + member.getId() + "', '" + member.getPw() + "', '" + member.getName() + "')";
			
			// 위에처럼 뉘역뉘역 쓰지 않고 전처리를 한다
			String sql = "INSERT INTO tbl_member(id, pw, name, email, road_addr, detail_addr) VALUES (?, ?, ?, ?, ?, ?)";
			
			// 1. connection 객체 취득
			conn = DriverManager.getConnection("jdbc:mariadb://43.203.219.241:3306/post", "sample", "1234");

			// 2. 문장 생성, 파라미터 지정
//			Statement stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, member.getId());
			pstmt.setString(idx++, member.getPw());
			pstmt.setString(idx++, member.getName());
			pstmt.setString(idx++, member.getEmail());
			pstmt.setString(idx++, member.getRoadAddr());
			pstmt.setString(idx++, member.getDetailAddr());
			
			// 3. 문장 실행
//			return stmt.executeUpdate(sql);
			return pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException ignore) { }
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		int result = dao.insert(Member.builder()
				.id("ffff")
				.pw("1234567")
				.name("이름")
				.email("abc@naver.com")
				.roadAddr("대륭")
				.detailAddr("4층").build());
		System.out.println(result);
	}
}