package com.taodian.mockapi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ����Ķ���ַ��ص���Ϣ�� ����������ַ���ͳ�ƣ��������������ͳ����Ҫ�õ�����Ϣ��
 * <br/>
 * �ֶη�Ϊ2���ࣺ<br/>
 * 	a. ����ַ�ľ�̬��Ϣ�����磺����ַ���Կ��û�ID����ƷID��ð�ݿ�ID<br/>
 *  b. ���ε���Ķ�̬���ݣ����磺�����agent, �ÿ�ID, �ͻ���IP �ȡ� <br/>
 * 
 * 
 * @author deonwu
 */
public class ShortUrlModel implements Serializable, Cloneable{
	public static final int DEVICE_PC = 9;
	public static final int DEVICE_IPAD = 1;
	public static final int DEVICE_IPHONE = 2;
	public static final int DEVICE_ANDROID = 3;
	public static final int DEVICE_OTHER_MOBILE = 4;	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6956443049935100082L;
	
	/**
	 * ����¼�ID����������һ�ε������������ʱ����ͷÿ�ID���ɡ�����־�����¼���������Ψһ������
	 */
	public long clickId = 0;
	
	/**
	 * �ÿ�ID ��������
	 */
	public long numUid = 0;
	
	/**
	 * �ַ��ͷÿ�ID�� �ÿ�ID��Ϊÿһ�������û������ID�������ڷ����ߵ������Cookie���档����
	 * ���ָ���һ���û���
	 * 
	 * ID������һ��long ���֡�Ϊ��һЩͳ�Ʒ��㱣����һ���ַ����ֶΡ�
	 */
	public String uid = null;
	
	/**
	 * uid ��Ӧ���û�����
	 */
	public WeiboVisitor visitor = null;
	
	/**
	 * ������������User-agent, ������������͵���Ϣ��
	 */
	public String agent = null;
	
	/**
	 * �Ա�����ID����ͨ΢���ƹ���Ʒʱ������ID����Ϊ�ա�
	 */
	public long shopId = 0;
	
	/**
	 * �Ա���ƷID������ǵ����ƹ����ӵĻ�������ֶ�Ϊ0.
	 */
	public long numIid = 0;
	
	/**
	 * ���ɶ����ӵ�Ӧ��ID�� ���磺ð����-2, 45min-12. ���Ҫ���ٵ��������ſͻ��˵ĵ�������Ը���
	 * ���ID ͳ�ơ�
	 * 
	 */
	public int appId = 0;
	
	/**
	 * �Կ͵�userId�����ID ��ÿ��appId��Ψһ��
	 */
	public int userId = 0;
	
	/**
	 * ����ַ����ǻ�Ļ�����������ID
	 */
	public int topicId = 0;

	/**
	 * ������ʵ���������ͣ�1:iPad�� 2:iPhone, 3:Android, 4:�����ֻ�, 9:PC�� 0��δ֪
	 */
	public int deviceType = 0;
	public String deviceName = "";
	public String browserName = "";
	
	public String agentHash = "";
	public String referHash = "";
	
	/**
	 * ð�����ģ��İ���ID��
	 */
	public int libId = 0;
	/**
	 * ΢��ID
	 */
	public String outId = null;
	public String platform = null;
	
	/**
	 * ����Ŀͻ���IP�����磺104.11.20.11
	 */
	public String ip = null;
	
	
	/**
	 * ����Ķ���ַ��14λ���ڵ��ַ�����
	 */
	public String shortKey = null;

	/**
	 * �������Դ�����磺http://t.qq.com/q879779218�� ���������������ת���Ͳ�׼ȷ�ˣ�
	 * ��������΢������Դ���ǣ�http://h2w.iask.cn/jump.php?url=http://wap.emop.cn/c/s7ce147b
	 */
	public String refer = null;
	
	public String shortKeySource = null;
	
	public boolean isMobile=false;
	
	/**
	 * ����ַ
	 */
	public String longUrl = null;

	/**
	 * �ƶ��泤��ַ
	 */
	public String mobileLongUrl = null;
	
	/**
	 * ����ַ���ضԵ�ǰ����ĳ�����ʽ���Ǿܾ����ǣ���ת��
	 */
	public String action = null;
	
	
	public Date clickTime = new Date(System.currentTimeMillis());

	public int hashCode(){
		return shortKey != null ? (int)shortKey.hashCode() : 0;
	}
	
	public boolean equals(ShortUrlModel o){
		if(o instanceof ShortUrlModel){
			return o.hashCode() == this.hashCode();
		}else {
			return false;
		}
	}
	
	public ShortUrlModel copy(){
		ShortUrlModel m = null;
		try {
			m = (ShortUrlModel) this.clone();
		} catch (CloneNotSupportedException e) {
		}
		
		return m;
	}
}
