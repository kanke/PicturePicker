package com.kanke.camera;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by kanke on 17/10/2015.
 */
public class ImagePickActivityTest extends ActivityInstrumentationTestCase2<ImagePickActivity> {

    private ImageView imageView;

    private Button pictureButton;

    private ImagePickActivity imagePickActivity;

    public ImagePickActivityTest() {
        super(ImagePickActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();

        imagePickActivity = getActivity();

        imageView = (ImageView) imagePickActivity.findViewById(R.id.imageResult);

        pictureButton = (Button) imagePickActivity.findViewById(R.id.picture_button);

    }

    /**
     * Test if your test fixture has been set up correctly. You should always implement a test that
     * checks the correct setup of your test fixture. If this tests fails all other tests are
     * likely to fail as well.
     * @MeduiumTest Annotation :-  Accesses file systems on box which is running tests.
     */
    @MediumTest
    public void testPreconditions() {
        //Try to add a message to add context to your assertions. These messages will be shown if
        //a tests fails and make it easy to understand why a test failed
        assertNotNull("ImageView is null", imageView);
        assertNotNull("imagePickActivity is null", imagePickActivity);
        assertNotNull("PictureButton is null", pictureButton);
    }

    @MediumTest
    public void testPictureButtonLabelText() {
        //Verify that pictureButton uses the correct string resource
        final String expectedPictureButtonText = imagePickActivity.getString(R.string.picture_button);
        final String actualPictureButtonText = pictureButton.getText().toString();
        assertEquals(expectedPictureButtonText, actualPictureButtonText);
    }

     @MediumTest
    public void testClickPictureButton() {
        TouchUtils.clickView(this, pictureButton);
        //Verify the that pictureButton was clicked. imageView is visible and contains
        assertTrue(View.VISIBLE == imageView.getVisibility());

    }

}