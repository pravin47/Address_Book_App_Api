package com.bridgelabz.addressbookapi.exception;
import java.util.Locale;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bridgelabz.addressbookapi.util.ErrorResponse;
import com.bridgelabz.addressbookapi.util.Response;
import lombok.Data;

@ResponseStatus
@Data
public class ContactRegisterException  extends RuntimeException
{
	public ContactRegisterException(int statusCode, String statusmessage)
	{
		super(statusmessage);
		StatusCode = statusCode;
		Statusmessage = statusmessage;
	}
	
	private static final long serialVersionUID = 1L;
	
	private int StatusCode;
	private String Statusmessage;
	
	public Response getErrorResponse() 
	{
		return getErrorResponse(Locale.getDefault());
	}
	
	public Response getErrorResponse(Locale locale) 
	{
		ErrorResponse err = new ErrorResponse(StatusCode, Statusmessage, getStackTrace());
		//err.setStatusCode(getStatusCode());
		//err.setStatusmessage(getStatusmessage());

		return err;
    }
}