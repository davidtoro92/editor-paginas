package cl.scloud.editor.paginas.enums;

public enum OpcionesMenuNavegacionEnum {

	HOME("HOME"), ABOUT("ABOUT"), BLOG("BLOG"), CONTACT("CONTACT");
	
	private String opcionMenu;
	
	private OpcionesMenuNavegacionEnum(String opcionMenu) {
		this.opcionMenu = opcionMenu;
	}

	public String getOpcionMenu() {
		return opcionMenu;
	}

	public void setOpcionMenu(String opcionMenu) {
		this.opcionMenu = opcionMenu;
	}
}
