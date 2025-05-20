package namedEntity;


/*Esta clase modela la nocion de entidad nombrada*/

public class NamedEntity {
	String name;
	String category;
	String topic;
	int frequency;
	
	public NamedEntity(String name, String category, String topic, int frequency) {
		super();
		this.name = name;
		this.category = category;
		this.topic = topic;
		this.frequency = frequency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return name;
	}

	public void setCategory(String name) {
		this.name = name;
	}

	public String getTopic() {
		return name;
	}

	public void setTopic(String name) {
		this.name = name;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void incFrequency() {
		this.frequency++;
	}

	@Override
	public String toString() {
		return "ObjectNamedEntity [name=" + name + ", frequency=" + frequency + "]";
	}
	public void prettyPrint(){
		System.out.println(this.getName() + " " + this.getFrequency());
	}
}



