package lab5;

public class BorrowingBookResult {
	private boolean isSuccess;
	private String borrowingMessage;
	
	public BorrowingBookResult(boolean isSuccess,String borrowingMessage) { 
			this.isSuccess = isSuccess;
			this.borrowingMessage = borrowingMessage;
	}
	
	public boolean getIsSuccess(){
		return isSuccess;
	}
	
	public void setIsSuccess(boolean isSuccess){
		this.isSuccess = isSuccess;
	}
	
	public void setMessage(String borrowingMessage) {
		this.borrowingMessage = borrowingMessage;
	}
	
	public String getMessage() {
		return borrowingMessage;
	}
	
	
}
