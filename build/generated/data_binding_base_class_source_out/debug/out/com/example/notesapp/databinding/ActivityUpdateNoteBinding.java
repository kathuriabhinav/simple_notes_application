// Generated by view binder compiler. Do not edit!
package com.example.notesapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.notesapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityUpdateNoteBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton UpdateNotesButton;

  @NonNull
  public final ImageView upGreenPriority;

  @NonNull
  public final EditText upNotes;

  @NonNull
  public final ImageView upRedPriority;

  @NonNull
  public final EditText upSubtitle;

  @NonNull
  public final EditText upTitle;

  @NonNull
  public final ImageView upYellowPriority;

  private ActivityUpdateNoteBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton UpdateNotesButton, @NonNull ImageView upGreenPriority,
      @NonNull EditText upNotes, @NonNull ImageView upRedPriority, @NonNull EditText upSubtitle,
      @NonNull EditText upTitle, @NonNull ImageView upYellowPriority) {
    this.rootView = rootView;
    this.UpdateNotesButton = UpdateNotesButton;
    this.upGreenPriority = upGreenPriority;
    this.upNotes = upNotes;
    this.upRedPriority = upRedPriority;
    this.upSubtitle = upSubtitle;
    this.upTitle = upTitle;
    this.upYellowPriority = upYellowPriority;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityUpdateNoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityUpdateNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_update_note, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityUpdateNoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.UpdateNotesButton;
      FloatingActionButton UpdateNotesButton = rootView.findViewById(id);
      if (UpdateNotesButton == null) {
        break missingId;
      }

      id = R.id.up_green_priority;
      ImageView upGreenPriority = rootView.findViewById(id);
      if (upGreenPriority == null) {
        break missingId;
      }

      id = R.id.upNotes;
      EditText upNotes = rootView.findViewById(id);
      if (upNotes == null) {
        break missingId;
      }

      id = R.id.up_red_priority;
      ImageView upRedPriority = rootView.findViewById(id);
      if (upRedPriority == null) {
        break missingId;
      }

      id = R.id.upSubtitle;
      EditText upSubtitle = rootView.findViewById(id);
      if (upSubtitle == null) {
        break missingId;
      }

      id = R.id.upTitle;
      EditText upTitle = rootView.findViewById(id);
      if (upTitle == null) {
        break missingId;
      }

      id = R.id.up_yellow_priority;
      ImageView upYellowPriority = rootView.findViewById(id);
      if (upYellowPriority == null) {
        break missingId;
      }

      return new ActivityUpdateNoteBinding((RelativeLayout) rootView, UpdateNotesButton,
          upGreenPriority, upNotes, upRedPriority, upSubtitle, upTitle, upYellowPriority);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
