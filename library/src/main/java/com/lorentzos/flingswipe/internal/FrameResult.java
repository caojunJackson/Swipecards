package com.lorentzos.flingswipe.internal;

import static com.lorentzos.flingswipe.internal.Direction.CENTER;
import static com.lorentzos.flingswipe.internal.Direction.LEFT;
import static com.lorentzos.flingswipe.internal.Direction.RIGHT;
import static com.lorentzos.flingswipe.internal.EndEvent.EXIT;
import static com.lorentzos.flingswipe.internal.EndEvent.RECENTER;
import static java.lang.Math.abs;

/**
 * The resulting details for the view when the user moves up or cancels
 * the drag events.
 */
public class FrameResult {

	private static final FrameResult CLICK = new FrameResult(EndEvent.CLICK, CENTER);
	private final int endEventYpe;
	private final int direction;

	/**
	 * Creates a new instance for the given scrolling progress
	 *
	 * @param scrollProgress the progress of scrolling for the view.
	 * @return a new instance of {@link FrameResult}
	 */
	static FrameResult fromScrollProgress(float scrollProgress) {

		if (abs(scrollProgress + 1) == 0) {
			return new FrameResult(EXIT, LEFT);

		}
		if (abs(scrollProgress - 1) == 0) {
			return new FrameResult(EXIT, RIGHT);
		}

		return new FrameResult(RECENTER, CENTER);
	}

	/**
	 * Creates a instance related to a click event.
	 *
	 * @return a new instance of {@link FrameResult}
	 */
	static FrameResult click() {
		return CLICK;
	}

	private FrameResult(@EndEvent int endEventYpe, @Direction int direction) {
		this.endEventYpe = endEventYpe;
		this.direction = direction;
	}

	@EndEvent
	public int getEndEvent() {
		return endEventYpe;
	}

	@Direction
	public int getDirection() {
		return direction;
	}

}
