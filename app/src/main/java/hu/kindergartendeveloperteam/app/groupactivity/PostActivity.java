package hu.kindergartendeveloperteam.app.groupactivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.appcompat.app.AppCompatActivity;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Post;

@SuppressWarnings("deprecation")
public class PostActivity extends AppCompatActivity {

    public static final int IMAGE_GALLERY_REQUEST = 20;
    public ImageView imagePicture;
    TextInputEditText textIn;
    DefaultApi db = new DefaultApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_create_activity);

        textIn = (TextInputEditText)findViewById(R.id.PostTextInputEditText);
        imagePicture = (ImageView) findViewById(R.id.photoPreview);
        Button addPhotoBtn = (Button) findViewById(R.id.addPhotoBtn);
        Button postBtn = (Button) findViewById(R.id.postBtn);

        addPhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageGalleryClicked(v);
            }
        });


        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost();

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    public void createPost() {
        try {
            Post newPost = new Post();
            newPost.setContent(textIn.getText().toString());

            imagePicture.buildDrawingCache();
            BitmapDrawable drawable = (BitmapDrawable) imagePicture.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,bos);
            byte[] bb = bos.toByteArray();
            String image = Base64.encodeBase64String(bb);
            newPost.setImage(image);

            int group_id = getIntent().getIntExtra(GroupChooseActivity.GROUP_ID, 0);
            db.createPost(group_id, newPost);

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    public void onImageGalleryClicked(View v)
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();
        Uri data = Uri.parse(pictureDirectoryPath);

        photoPickerIntent.setDataAndType(data, "image/*");

        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            // if we are here, everything processed successfully.
            if (requestCode == IMAGE_GALLERY_REQUEST) {
                // if we are here, we are hearing back from the image gallery.

                // the address of the image on the SD Card.
                Uri imageUri = data.getData();

                // declare a stream to read the image data from the SD Card.
                InputStream inputStream;

                // we are getting an input stream, based on the URI of the image.
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);

                    // get a bitmap from the stream.
                    Bitmap image = BitmapFactory.decodeStream(inputStream);

                    // show the image to the user
                    imagePicture.setImageBitmap(image);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    // show a message to the user indictating that the image is unavailable.
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
                }

            }
        }
    }
}
