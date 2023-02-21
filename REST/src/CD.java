import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cd")
public class CD {
	private String title;
	private String artist;
	public CD(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	public CD() {}
	@XmlElement
	public String getArtist() {
		return artist;
	}
	@XmlElement
	public String getTitle() {
		return title;
	}
}