package com.xiaopeng.xui.widgets.popup;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.xui.utils.UIUtils;
/* loaded from: classes.dex */
class XPopupCoordinatesFinder {
    XPopupCoordinatesFinder() {
    }

    private static void AdjustHorizontalCenteredOutOfBounds(View view, ViewGroup viewGroup, Point point, Coordinates coordinates) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int width = (viewGroup.getWidth() - viewGroup.getPaddingLeft()) - viewGroup.getPaddingRight();
        if (view.getMeasuredWidth() > width) {
            point.x = coordinates.left + viewGroup.getPaddingLeft();
            layoutParams.width = width;
            layoutParams.height = -2;
            view.setLayoutParams(layoutParams);
            measureViewWithFixedWidth(view, width);
        }
    }

    private static void AdjustHorizontalLeftAlignmentOutOfBounds(View view, ViewGroup viewGroup, Point point, Coordinates coordinates, Coordinates coordinates2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int paddingRight = coordinates2.right - viewGroup.getPaddingRight();
        if (point.x + view.getMeasuredWidth() > paddingRight) {
            layoutParams.width = paddingRight - coordinates.left;
            layoutParams.height = -2;
            view.setLayoutParams(layoutParams);
            measureViewWithFixedWidth(view, layoutParams.width);
        }
    }

    private static void AdjustHorizotalRightAlignmentOutOfBounds(View view, ViewGroup viewGroup, Point point, Coordinates coordinates, Coordinates coordinates2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int paddingLeft = coordinates2.left + viewGroup.getPaddingLeft();
        if (point.x < paddingLeft) {
            point.x = paddingLeft;
            layoutParams.width = coordinates.right - paddingLeft;
            layoutParams.height = -2;
            view.setLayoutParams(layoutParams);
            measureViewWithFixedWidth(view, layoutParams.width);
        }
    }

    private static void AdjustLeftToOutOfBounds(View view, ViewGroup viewGroup, Point point, Coordinates coordinates, Coordinates coordinates2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int paddingLeft = coordinates2.left + viewGroup.getPaddingLeft();
        if (point.x < paddingLeft) {
            point.x = paddingLeft;
            layoutParams.width = coordinates.left - paddingLeft;
            layoutParams.height = -2;
            view.setLayoutParams(layoutParams);
            measureViewWithFixedWidth(view, layoutParams.width);
        }
    }

    private static void AdjustRightToOutOfBounds(View view, ViewGroup viewGroup, Point point, Coordinates coordinates, Coordinates coordinates2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int paddingRight = (coordinates2.right - viewGroup.getPaddingRight()) - coordinates.right;
        if (point.x + view.getMeasuredWidth() > coordinates2.right - viewGroup.getPaddingRight()) {
            layoutParams.width = paddingRight;
            layoutParams.height = -2;
            view.setLayoutParams(layoutParams);
            measureViewWithFixedWidth(view, layoutParams.width);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Point getCoordinates(View view, XPopup xPopup) {
        Point point = new Point();
        Coordinates coordinates = new Coordinates(xPopup.getAnchorView());
        Coordinates coordinates2 = new Coordinates(xPopup.getRootView());
        view.measure(-2, -2);
        int position = xPopup.getPosition();
        if (position == 0) {
            point = getPositionAbove(view, xPopup, coordinates, coordinates2);
        } else if (position == 1) {
            point = getPositionBelow(view, xPopup, coordinates, coordinates2);
        } else if (position == 3) {
            point = getPositionLeftTo(view, xPopup, coordinates, coordinates2);
        } else if (position == 4) {
            point = getPositionRightTo(view, xPopup, coordinates, coordinates2);
        }
        point.x += UIUtils.isRtl() ? -xPopup.getOffsetX() : xPopup.getOffsetX();
        point.y += xPopup.getOffsetY();
        point.x -= xPopup.getRootView().getPaddingLeft();
        point.y -= xPopup.getRootView().getPaddingTop();
        return point;
    }

    private static Point getPositionAbove(View view, XPopup xPopup, Coordinates coordinates, Coordinates coordinates2) {
        Point point = new Point();
        point.x = coordinates.left + getXOffset(view, xPopup);
        if (xPopup.alignedCenter()) {
            AdjustHorizontalCenteredOutOfBounds(view, xPopup.getRootView(), point, coordinates2);
        } else if (xPopup.alignedLeft()) {
            AdjustHorizontalLeftAlignmentOutOfBounds(view, xPopup.getRootView(), point, coordinates, coordinates2);
        } else if (xPopup.alignedRight()) {
            AdjustHorizotalRightAlignmentOutOfBounds(view, xPopup.getRootView(), point, coordinates, coordinates2);
        }
        point.y = coordinates.top - view.getMeasuredHeight();
        return point;
    }

    private static Point getPositionBelow(View view, XPopup xPopup, Coordinates coordinates, Coordinates coordinates2) {
        Point point = new Point();
        point.x = coordinates.left + getXOffset(view, xPopup);
        if (xPopup.alignedCenter()) {
            AdjustHorizontalCenteredOutOfBounds(view, xPopup.getRootView(), point, coordinates2);
        } else if (xPopup.alignedLeft()) {
            AdjustHorizontalLeftAlignmentOutOfBounds(view, xPopup.getRootView(), point, coordinates, coordinates2);
        } else if (xPopup.alignedRight()) {
            AdjustHorizotalRightAlignmentOutOfBounds(view, xPopup.getRootView(), point, coordinates, coordinates2);
        }
        point.y = coordinates.bottom;
        return point;
    }

    private static Point getPositionLeftTo(View view, XPopup xPopup, Coordinates coordinates, Coordinates coordinates2) {
        Point point = new Point();
        point.x = coordinates.left - view.getMeasuredWidth();
        AdjustLeftToOutOfBounds(view, xPopup.getRootView(), point, coordinates, coordinates2);
        point.y = coordinates.top + getYCenteringOffset(view, xPopup);
        return point;
    }

    private static Point getPositionRightTo(View view, XPopup xPopup, Coordinates coordinates, Coordinates coordinates2) {
        Point point = new Point();
        point.x = coordinates.right;
        AdjustRightToOutOfBounds(view, xPopup.getRootView(), point, coordinates, coordinates2);
        point.y = coordinates.top + getYCenteringOffset(view, xPopup);
        return point;
    }

    private static int getXOffset(View view, XPopup xPopup) {
        int align = xPopup.getAlign();
        if (align != 0) {
            if (align == 1 || align != 2) {
                return 0;
            }
            return xPopup.getAnchorView().getWidth() - view.getMeasuredWidth();
        }
        return (xPopup.getAnchorView().getWidth() - view.getMeasuredWidth()) / 2;
    }

    private static int getYCenteringOffset(View view, XPopup xPopup) {
        return (xPopup.getAnchorView().getHeight() - view.getMeasuredHeight()) / 2;
    }

    private static void measureViewWithFixedWidth(View view, int i) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), -2);
    }
}
