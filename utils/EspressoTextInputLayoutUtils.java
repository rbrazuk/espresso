class EspressoTextInputLayoutUtils{
    /*
     * Use this method to find the EditText within the TextInputLayout. Useful for typing into the TextInputLayout
     */
    public static ViewInteraction onEditTextWithinTilWithId(@IdRes int textInputLayoutId) {
        //Note, if you have specified an ID for the EditText that you place inside
        //the TextInputLayout, use that instead - i.e, onView(withId(R.id.my_edit_text));
        return onView(allOf(isDescendantOfA(withId(textInputLayoutId)), isAssignableFrom(EditText.class)));
    }

    /*
     * Use this method to find the error view within the TextInputLayout. Useful for asseting that certain errors are displayed to the user
     */
    public static ViewInteraction onErrorViewWithinTilWithId(@IdRes int textInputLayoutId) {
        return onView(allOf(isDescendantOfA(withId(textInputLayoutId)), not(isAssignableFrom(EditText.class)), isAssignableFrom(TextView.class)));
    }


}
