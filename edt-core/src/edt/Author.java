package edt;

import java.io.Serializable;

public class Author implements Serializable, Comparable<Author>{

	/** Author's name */
	private String _name;

	/** Author's contact email */
	private String _email;

	/**
	 *	@param name
	 *				the author's name
	 *	@param email
	 *				the author's email
	 */
	public Author(String name, String email){
		_name = name;
		_email = email;
	}

	/** Returns the author's name */
	public String getName(){
		return _name;
	}

	/** Returns the author's email */
	public String getEmail(){
		return _email;
	}

	/** Sets the author's name (necessary?) */
	public void setName(String name){
		_name = name;
	}

	/** Sets the author's email (necessary?) */
	public void setEmail(String email){
		_email = email;
	}

	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Author other) {
		if(other == null) throw new NullPointerException(); // nao sei se é preciso exception aqui (javadocs diz que sim)
		return getName().compareTo(other.getName());
	}


	/** An author with the same name is considered equal */
	@Override
	public boolean equals(Object other){
		return other instanceof Author && _name.equals(((Author) other).getName());
	}

	/** see java.lang.Object#toString */
	@Override
	public String toString(){
		return "Author: " + _name + " (" + _email + ")";
	}

}