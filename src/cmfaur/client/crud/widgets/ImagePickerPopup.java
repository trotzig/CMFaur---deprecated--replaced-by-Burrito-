package cmfaur.client.crud.widgets;

import java.util.ArrayList;
import java.util.List;


import cmfaur.client.crud.labels.CrudMessages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;

public class ImagePickerPopup extends DialogBox {

	public static interface SaveHandler {
		void saved(String value);
	}

	private List<SaveHandler> saveHandlers = new ArrayList<SaveHandler>();
	private VerticalPanel wrapper = new VerticalPanel();
	private CrudMessages labels = GWT.create(CrudMessages.class);

	/**
	 * Creates an {@link ImagePickerPopup} that validates uploaded images
	 * against a strictly required width/height. Same as
	 * {@link ImagePickerPopup}(width, height, true)
	 * 
	 * @param width
	 * @param height
	 */

	public ImagePickerPopup(int width, int height) {
		this(width, height, true);
	}

	/**
	 * Creates an {@link ImagePickerPopup} that validates uploaded images
	 * against a required width and height. If strict is true then the uploaded
	 * image will be validated at exactly that size. If strict is false, then
	 * the uploaded image will be validated against a maximum size instead.
	 * 
	 * @param width
	 * @param height
	 * @param strict
	 *            whether or not the uploaded image size must strictly be width
	 *            x height
	 */
	public ImagePickerPopup(int width, int height, boolean strict) {
		super(true);
		setText(labels.uploadImage());
		final FormPanel form = new FormPanel();
		final HTML loading = new HTML(labels.uploadingProgress()
				+ "<span style=\"text-decoration: blink\">...</span>");
		loading.setVisible(false);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		form.setMethod(FormPanel.METHOD_POST);
		form.setAction("/images/upload?width=" + width + "&height=" + height + "&strict=" + strict);
		final FileUpload upload = new FileUpload();
		upload.setName("file");
		final Button doUpload = new Button(labels.doUpload(), new ClickHandler() {

			public void onClick(ClickEvent event) {
				form.submit();
			}
		});
		form.addSubmitHandler(new SubmitHandler() {

			public void onSubmit(SubmitEvent event) {
				setAutoHideEnabled(false);
				loading.setVisible(true);
				doUpload.setVisible(false);
			}
		});
		form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {

			public void onSubmitComplete(SubmitCompleteEvent event) {
				// reset loading info
				setAutoHideEnabled(true);
				loading.setVisible(false);
				doUpload.setVisible(true);

				// start by removing the annoying <pre> tags wrapping the result
				String clean = event.getResults().replaceAll("<[^>]+>", "");
				String[] split = clean.split("#");
				if (split[0].equals("OK")) {
					saved(split[1]);
				} else {
					Window
							.alert(labels.uploadError(clean));
				}
			}
		});
		form.setWidget(wrapper);
		if (strict) {
			wrapper.add(new Label(height == 0 ? labels.requiredImageWidth(width) : labels.requiredImageSize(width, height)));
		} else {
			wrapper.add(new Label(labels.maximumImageSize(width, height)));
		}
		wrapper.add(upload);
		wrapper.add(doUpload);
		wrapper.add(loading);
		setWidget(form);
	}

	public void addSaveHandler(SaveHandler saveHandler) {
		saveHandlers.add(saveHandler);
	}

	private void saved(final String path) {
		for (SaveHandler h : saveHandlers) {
			h.saved(path);
		}
		hide();
	}

}
