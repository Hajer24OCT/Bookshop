package com.example.agathachristie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeliveryOptions extends AppCompatActivity {

    private RadioGroup deliveryOptionsRadioGroup;
    private Button confirmButton;
    private DatabaseReference deliveryInfoRef;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_options);

        // Initialize views
        deliveryOptionsRadioGroup = findViewById(R.id.radio_group_delivery_options);
        confirmButton = findViewById(R.id.button_confirm_delivery);

        // Get reference to the Firebase database
        deliveryInfoRef = FirebaseDatabase.getInstance().getReference().child("users");

        // Get current authenticated user
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = deliveryOptionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId != -1) {
                    RadioButton selectedOption = findViewById(selectedOptionId);
                    String selectedOptionText = selectedOption.getText().toString();
                    saveDeliveryOption(selectedOptionText);
                    Toast.makeText(DeliveryOptions.this, "Selected option: " + selectedOptionText, Toast.LENGTH_SHORT).show();
                    // Perform any necessary actions based on the selected delivery option
                } else {
                    Toast.makeText(DeliveryOptions.this, "Please select a delivery option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveDeliveryOption(String option) {
        // Save the delivery option under the user's node in Firebase database
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference userDeliveryRef = deliveryInfoRef.child(userId).child("delivery");
            userDeliveryRef.setValue(option);
        }
    }
}




