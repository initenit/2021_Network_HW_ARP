package chat_file;

import java.util.ArrayList;

public class ARPLayer implements BaseLayer {
	public int nUpperLayerCount = 0;
	public String pLayerName = null;
	public BaseLayer p_UnderLayer = null;
	public ArrayList<BaseLayer> p_aUpperLayer = new ArrayList<BaseLayer>();
	
	private class _ARP_ADDR {
		private byte[] mac_addr = new byte[6];
		private byte[] ip_addr = new byte[4];
		
		public _ARP_ADDR() {
			for(int i = 0; i < mac_addr.length; i++) {
				mac_addr[i] = (byte) 0x00;
			}
			for(int i = 0; i < ip_addr.length; i++) {
				ip_addr[i] = (byte)0x00;
			}
		}
	}
	
	private class _ARP_HEADER {
		byte[] mac_type;
		byte[] ip_type;
		byte mac_size;
		byte ip_size;
		byte[] op_field;
		_ARP_ADDR sender_addr;
		_ARP_ADDR target_addr;
		
		public _ARP_HEADER() {
			this.mac_type = new byte[2];
			this.ip_type = new byte[2];
			this.mac_size = 0x06;
			this.ip_size = 0x04;
			this.op_field = new byte[2];
			this.sender_addr = new _ARP_ADDR();
			this.target_addr = new _ARP_ADDR();
		}
	}
	
	public ARPLayer(String pName) {
		pLayerName = pName;
		
	}
	
	public boolean Send(byte[] input, int length) {
		
		return false;
	}
	
	public boolean Receive(byte[] input) {
		
		return false;
	}

	@Override
	public String GetLayerName() {
		// TODO Auto-generated method stub
		return pLayerName;
	}

	@Override
	public BaseLayer GetUnderLayer() {
		// TODO Auto-generated method stub
		if(p_UnderLayer == null)
			return null;
		return p_UnderLayer;
	}

	@Override
	public BaseLayer GetUpperLayer(int nindex) {
		// TODO Auto-generated method stub
		if(nindex < 0 || nindex > nUpperLayerCount || nUpperLayerCount < 0)
			return null;
		return p_aUpperLayer.get(nindex);
	}

	@Override
	public void SetUnderLayer(BaseLayer pUnderLayer) {
		// TODO Auto-generated method stub
		if(pUnderLayer == null)
			return;
		this.p_UnderLayer = pUnderLayer;
	}

	@Override
	public void SetUpperLayer(BaseLayer pUpperLayer) {
		// TODO Auto-generated method stub
		if(pUpperLayer == null)
			return;
		this.p_aUpperLayer.add(nUpperLayerCount++, pUpperLayer);
	}

	@Override
	public void SetUpperUnderLayer(BaseLayer pUULayer) {
		// TODO Auto-generated method stub
		this.SetUpperLayer(pUULayer);
		pUULayer.SetUnderLayer(this);
	}

}
