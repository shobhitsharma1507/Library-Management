package modelTO;

import java.sql.Date;

public class MemberTO {
    private String memberId;
    private String memberName;
    private Date dob;
    private Date joindate;
    private String address;
    private int issuedBooks;
    private int returnBooks;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(int issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public int getReturnBooks() {
        return returnBooks;
    }

    public void setReturnBooks(int returnBooks) {
        this.returnBooks = returnBooks;
    }
    
    
}
