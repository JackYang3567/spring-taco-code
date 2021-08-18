package tacos;

public class Greeting {

	private final long id;
	private final String uuid;
	private final String content;

	public Greeting(long id, String uuid, String content) {
		this.id = id;
		this.uuid = uuid;
		this.content = content;
	}

	public long getId() {
		return id;
	}
	
	public String getUuid() {
		return uuid;
	}

	public String getContent() {
		return content;
	}
	
}
