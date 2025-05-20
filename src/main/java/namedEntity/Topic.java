package namedEntity;

public class Topic {
    String name;
    String topic;
    String frequency;

    public Topic(String name, String topic, String frequency) {
        this.name = name;
        this.topic = topic;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void incFrequency() {
        this.frequency = this.frequency +1;
    }

    @Override
    public String toString() {
        return "ObjectNamedEntity [name=" + name + ", frequency=" + frequency + "]";
    }

    public void prettyPrint() {
        System.out.println(this.getName() + " " + this.getFrequency());
    }
}
