com.conformiq.creator.structure.v15
creator.gui.screen qml5a6f876dde5b45f4a4f9b6fe78e4ab1f "Login"
{
	creator.gui.form qml50e18539aaa6499eadf691c9b3d32c48 "Login"
	{
		creator.gui.textbox qml18b3068a30b24728a338a51f4737d7b7 "Username"
			type = String
			status = dontcare;
		creator.gui.textbox qmlb51581a714c64caa8f7e9980a479af90 "Password"
			type = String
			status = dontcare;
	}
}
creator.gui.screen qmla9ef6a638bd046c0bffeefc59466a1a2 "Home"
{
	creator.gui.form qmla45def6598e24812aab84eb812a17c7e "Order"
	{
		creator.gui.textbox qml13db74f49518425380d07e23e1bd1d1c "Order Number"
			type = String
			status = dontcare;
	}
	creator.gui.hyperlink qml74704d1ff5af446e8f435b4a65b3c63b "Order 12345"
		status = dontcare;
	creator.gui.button qml6f49fbcf7e704b9ea9b0a98009414d19 "Next"
		status = dontcare;
	creator.gui.form qml080ed8cfb4ea4566b0c454f8da373f2c "Order Info"
	{
		creator.gui.textbox qml54d15ad2cca545b4be0fb0645de5f5cd "Order Id"
			type = String
			status = dontcare;
	}
}
creator.gui.screen qml1f4a28b3797e4bda922ee5018c0146da "Order Details"
{
	creator.gui.labelwidget qmle93d3c62aff1477a830040006c6900fc "OrderNumber"
		status = dontcare;
	creator.gui.labelwidget qmle25b1b248152497385b68435fe5a17bf "QTY"
		status = dontcare;
	creator.gui.form qml4032155565d343b0927233be2685a255 "Order"
	{
		creator.gui.textbox qml00090148ceac45f687415780886e55a5 "Ordered Number"
			type = String
			status = dontcare;
	}
}
creator.gui.screen qml820d30a3c1234c1599a11c2a210ab205 "Funds Transfer"
{
	creator.gui.button qml64fdb70472814325984b58eac2b584ff "Transfer"
		status = dontcare;
}