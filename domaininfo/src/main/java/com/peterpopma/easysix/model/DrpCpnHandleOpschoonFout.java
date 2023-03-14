package nl.sidn.drs.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRP_CPN_HANDLE_OPSCHOON_FOUT database table.
 * 
 */
@Entity
@Table(name="DRP_CPN_HANDLE_OPSCHOON_FOUT")
@NamedQuery(name="DrpCpnHandleOpschoonFout.findAll", query="SELECT d FROM DrpCpnHandleOpschoonFout d")
public class DrpCpnHandleOpschoonFout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CPN_HANDLE", nullable=false, length=20)
	private String cpnHandle;

	public DrpCpnHandleOpschoonFout() {
	}

	public String getCpnHandle() {
		return this.cpnHandle;
	}

	public void setCpnHandle(String cpnHandle) {
		this.cpnHandle = cpnHandle;
	}

}