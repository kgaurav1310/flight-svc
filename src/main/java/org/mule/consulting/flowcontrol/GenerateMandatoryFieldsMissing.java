package org.mule.consulting.flowcontrol;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class GenerateMandatoryFieldsMissing extends Exception implements Callable {
    private static final long serialVersionUID = 1L;
    private int status = 200;
    private String reason = FlightAppConstants.Exception.OK;
    private String payload = FlightAppConstants.Exception.EMPTYSTRING;

    public GenerateMandatoryFieldsMissing() {
    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public String getReason() {
	return reason;
    }

    public void setReason(String reason) {
	this.reason = reason;
    }

    public String getPayload() {
	return payload;
    }

    public void setPayload(String payload) {
	this.payload = payload;
    }

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
	MuleMessage message = eventContext.getMessage();
	message.setInvocationProperty(FlightAppConstants.Exception.REASON,
		FlightAppConstants.Exception.MANDATORY_FIELD_MISSING_ERROR);
	throw this;
    }

}
