package edu.gatech.cs2340.spacetrader.models;

public class FrontPage extends AppCompatAcitivity {

	private Button signIn;
	private Button register;
	private Button forgotPassword;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		signIn = findViewId(R.id.____);
		register = findViewId(R.id.____);
		forgotPassword = findViewId(R.id.____);
	}

}