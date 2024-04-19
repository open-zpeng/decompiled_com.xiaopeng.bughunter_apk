package defpackage;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
/* compiled from: PrecomputedTextCompat.java */
/* renamed from: o3  reason: default package */
/* loaded from: classes.dex */
public class o3 implements Spannable {
    private static final Object b = new Object();
    private final Spannable c;
    private final a d;
    private final PrecomputedText e;

    public a a() {
        return this.d;
    }

    public PrecomputedText b() {
        Spannable spannable = this.c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.c.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T[]) this.e.getSpans(i, i2, cls);
        }
        return (T[]) this.c.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.c.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e.removeSpan(obj);
                return;
            } else {
                this.c.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e.setSpan(obj, i, i2, i3);
                return;
            } else {
                this.c.setSpan(obj, i, i2, i3);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.c.toString();
    }

    /* compiled from: PrecomputedTextCompat.java */
    /* renamed from: o3$a */
    /* loaded from: classes.dex */
    public static final class a {
        private final TextPaint a;
        private final TextDirectionHeuristic b;
        private final int c;
        private final int d;
        final PrecomputedText.Params e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: o3$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0045a {
            private final TextPaint a;
            private TextDirectionHeuristic b;
            private int c;
            private int d;

            public C0045a(TextPaint textPaint) {
                this.a = textPaint;
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                if (i >= 18) {
                    this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.b = null;
                }
            }

            public a a() {
                return new a(this.a, this.b, this.c, this.d);
            }

            public C0045a b(int i) {
                this.c = i;
                return this;
            }

            public C0045a c(int i) {
                this.d = i;
                return this;
            }

            public C0045a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.e = null;
            }
            this.a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = i;
            this.d = i2;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public TextDirectionHeuristic c() {
            return this.b;
        }

        public TextPaint d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            PrecomputedText.Params params = this.e;
            if (params != null) {
                return params.equals(aVar.e);
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 23 || (this.c == aVar.a() && this.d == aVar.b())) {
                if ((i < 18 || this.b == aVar.c()) && this.a.getTextSize() == aVar.d().getTextSize() && this.a.getTextScaleX() == aVar.d().getTextScaleX() && this.a.getTextSkewX() == aVar.d().getTextSkewX()) {
                    if ((i < 21 || (this.a.getLetterSpacing() == aVar.d().getLetterSpacing() && TextUtils.equals(this.a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) && this.a.getFlags() == aVar.d().getFlags()) {
                        if (i >= 24) {
                            if (!this.a.getTextLocales().equals(aVar.d().getTextLocales())) {
                                return false;
                            }
                        } else if (i >= 17 && !this.a.getTextLocale().equals(aVar.d().getTextLocale())) {
                            return false;
                        }
                        if (this.a.getTypeface() == null) {
                            if (aVar.d().getTypeface() != null) {
                                return false;
                            }
                        } else if (!this.a.getTypeface().equals(aVar.d().getTypeface())) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return x3.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 21) {
                return x3.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 18) {
                return x3.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 17) {
                return x3.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            return x3.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.a.getTextSize());
            sb.append(", textScaleX=" + this.a.getTextScaleX());
            sb.append(", textSkewX=" + this.a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                sb.append(", letterSpacing=" + this.a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            }
            if (i >= 24) {
                sb.append(", textLocale=" + this.a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.a.getTextLocale());
            }
            sb.append(", typeface=" + this.a.getTypeface());
            if (i >= 26) {
                sb.append(", variationSettings=" + this.a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.b);
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            this.e = params;
        }
    }
}
