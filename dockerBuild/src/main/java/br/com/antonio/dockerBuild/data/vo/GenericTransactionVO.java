package br.com.antonio.dockerBuild.data.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonIgnoreProperties(value={"pPartner"}, allowGetters=true, allowSetters=true)
public class GenericTransactionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@JsonProperty("pPartner")
	
	@JsonInclude(Include.NON_NULL)
	private String partnerId;
	
	@JsonInclude(Include.NON_NULL)
	private String transactionStatus;
	
	@JsonInclude(Include.NON_NULL)
	private String transactionType;
	
	private List<GenericInformationsVO> generic;
	
	public GenericTransactionVO() {
				//super();
		// TODO Auto-generated constructor stub
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public List<GenericInformationsVO> getGeneric() {
		return generic;
	}

	public void setGeneric(List<GenericInformationsVO> generic) {
		this.generic = generic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generic == null) ? 0 : generic.hashCode());
		result = prime * result + ((partnerId == null) ? 0 : partnerId.hashCode());
		result = prime * result + ((transactionStatus == null) ? 0 : transactionStatus.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericTransactionVO other = (GenericTransactionVO) obj;
		if (generic == null) {
			if (other.generic != null)
				return false;
		} else if (!generic.equals(other.generic))
			return false;
		if (partnerId == null) {
			if (other.partnerId != null)
				return false;
		} else if (!partnerId.equals(other.partnerId))
			return false;
		if (transactionStatus == null) {
			if (other.transactionStatus != null)
				return false;
		} else if (!transactionStatus.equals(other.transactionStatus))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}

	
	

	
	

	

	

	

}
