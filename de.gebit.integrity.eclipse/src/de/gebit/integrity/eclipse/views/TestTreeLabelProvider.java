package de.gebit.integrity.eclipse.views;

import java.util.Set;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.gebit.integrity.eclipse.Activator;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryResultStates;

public class TestTreeLabelProvider extends LabelProvider implements ILabelProvider {

	private SetList setList;

	private Set<Integer> breakpointSet;

	private Image suiteImage;
	private Image suiteSuccessImage;
	private Image suiteFailureImage;
	private Image suiteExceptionImage;
	private Image testImage;
	private Image testSuccessImage;
	private Image testFailureImage;
	private Image testExceptionImage;
	private Image callImage;
	private Image callSuccessImage;
	private Image callExceptionImage;

	public TestTreeLabelProvider(SetList aSetList, Set<Integer> aBreakpointSet) {
		setList = aSetList;
		breakpointSet = aBreakpointSet;
		suiteImage = Activator.getImageDescriptor("icons/suite.gif").createImage();
		suiteSuccessImage = Activator.getImageDescriptor("icons/suite_ok.gif").createImage();
		suiteFailureImage = Activator.getImageDescriptor("icons/suite_error.gif").createImage();
		suiteExceptionImage = Activator.getImageDescriptor("icons/suite_exception.gif").createImage();
		testImage = Activator.getImageDescriptor("icons/test.png").createImage();
		testSuccessImage = Activator.getImageDescriptor("icons/test_success.gif").createImage();
		testFailureImage = Activator.getImageDescriptor("icons/test_failed.gif").createImage();
		testExceptionImage = Activator.getImageDescriptor("icons/test_exception.gif").createImage();
		callImage = Activator.getImageDescriptor("icons/call.gif").createImage();
		callSuccessImage = Activator.getImageDescriptor("icons/call_success.gif").createImage();
		callExceptionImage = Activator.getImageDescriptor("icons/call_exception.gif").createImage();
	}

	@Override
	public void dispose() {
		super.dispose();
		suiteImage.dispose();
		suiteSuccessImage.dispose();
		suiteFailureImage.dispose();
		suiteExceptionImage.dispose();
		testImage.dispose();
		testSuccessImage.dispose();
		testFailureImage.dispose();
		testExceptionImage.dispose();
		callImage.dispose();
		callSuccessImage.dispose();
		callExceptionImage.dispose();
	}

	public Image getImage(Object element) {
		SetListEntry tempEntry = (SetListEntry) element;
		SetListEntryResultStates tempResultState = setList.getResultStateForEntry(tempEntry);

		if (tempResultState != null) {
			switch (tempEntry.getType()) {
			case SUITE:
				switch (tempResultState) {
				case SUCCESSFUL:
					return suiteSuccessImage;
				case FAILED:
					return suiteFailureImage;
				case EXCEPTION:
					return suiteExceptionImage;
				case UNKNOWN:
				default:
					return suiteImage;
				}
			case CALL:
				switch (tempResultState) {
				case SUCCESSFUL:
					return callSuccessImage;
				case EXCEPTION:
					return callExceptionImage;
				case UNKNOWN:
				default:
					return callImage;
				}
			case TEST:
			case TABLETEST:
			case RESULT:
				switch (tempResultState) {
				case SUCCESSFUL:
					return testSuccessImage;
				case FAILED:
					return testFailureImage;
				case EXCEPTION:
					return testExceptionImage;
				case UNKNOWN:
				default:
					return testImage;
				}
			default:
				return null;
			}
		}

		return null;
	}

	@Override
	public String getText(Object element) {
		SetListEntry tempEntry = (SetListEntry) element;
		SetListEntryResultStates tempResultState = setList.getResultStateForEntry(tempEntry);

		String tempSuffix = "";
		if ((tempResultState == null || tempResultState == SetListEntryResultStates.UNKNOWN)
				&& setList.isEntryInExecution(tempEntry)) {
			tempSuffix = "...";
		} else if (breakpointSet.contains(tempEntry.getId())) {
			tempSuffix = " ";
		}

		switch (tempEntry.getType()) {
		case SUITE:
			return ((String) tempEntry.getAttribute(SetListEntryAttributeKeys.NAME)) + tempSuffix;
		case TEST:
		case TABLETEST:
		case CALL:
			return ((String) tempEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION)) + tempSuffix;
		case RESULT:
			return ((String) tempEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION)) + tempSuffix;
		default:
			return tempEntry.toString() + tempSuffix;
		}
	}

}