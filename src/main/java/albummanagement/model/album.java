package albummanagement.model;

public class album {
	
	private int id;
	private String album;
	private String artist;
	private String languages;
	
	
	
	public album(int id, String album, String artist, String languages) {
		super();
		this.id = id;
		this.album = album;
		this.artist = artist;
		this.languages = languages;
	}
	
	
	
	public album(String album, String artist, String languages) {
		super();
		this.album = album;
		this.artist = artist;
		this.languages = languages;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/*public String getLanguage() {
		return languages;
	}
	public void setLanguage(String languages) {
		this.languages = languages;
	}*/
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}

	

}
