package me.gaelan.holeylands

import org.spongepowered.api.text.Text
import org.spongepowered.api.text.Texts
import org.spongepowered.api.text.action.ClickAction
import org.spongepowered.api.text.action.HoverAction
import org.spongepowered.api.text.action.ShiftClickAction
import org.spongepowered.api.text.format.TextColors
import org.spongepowered.api.text.format.TextStyles

// Extension functions are functions written outside the class, but inside the
// class's scope. What that means is you can add methods to classes you don't
// control. Pretty nifty. These operate on Strings and Texts, to give them
// styling. For instance, "Green!".green().bold() returns a bold, green Text
// object which you can then use like any other. These functions can be chained
// as much as you like.
//
// In Kotlin, unary and binary operators are exposed as methods like plus(),
// etc. I've defined a Text.plus(String) function, a String.plus(Text)
// function, and a Text.plus(Text) function to easily combine multiple styles.
// This proves to be super useful. "Blue part".blue() + " white bit " + "red"
// .red() combines two Texts and a plain String into one Text.

fun Text.aqua(): Text = Texts.builder().color(TextColors.AQUA).append(this).toText()
fun Text.black(): Text = Texts.builder().color(TextColors.BLACK).append(this).toText()
fun Text.blue(): Text = Texts.builder().color(TextColors.BLUE).append(this).toText()
fun Text.darkAqua(): Text = Texts.builder().color(TextColors.DARK_AQUA).append(this).toText()
fun Text.darkBlue(): Text = Texts.builder().color(TextColors.DARK_BLUE).append(this).toText()
fun Text.darkGray(): Text = Texts.builder().color(TextColors.DARK_GRAY).append(this).toText()
fun Text.darkGreen(): Text = Texts.builder().color(TextColors.DARK_GREEN).append(this).toText()
fun Text.darkPurple(): Text = Texts.builder().color(TextColors.DARK_PURPLE).append(this).toText()
fun Text.darkRed(): Text = Texts.builder().color(TextColors.DARK_RED).append(this).toText()
fun Text.gold(): Text = Texts.builder().color(TextColors.GOLD).append(this).toText()
fun Text.gray(): Text = Texts.builder().color(TextColors.GRAY).append(this).toText()
fun Text.green(): Text = Texts.builder().color(TextColors.GREEN).append(this).toText()
fun Text.lightPurple(): Text = Texts.builder().color(TextColors.LIGHT_PURPLE).append(this).toText()
fun Text.red(): Text = Texts.builder().color(TextColors.RED).append(this).toText()
fun Text.yellow(): Text = Texts.builder().color(TextColors.YELLOW).append(this).toText()
fun Text.white(): Text = Texts.builder().color(TextColors.WHITE).append(this).toText()

fun Text.bold(): Text = Texts.builder().style(TextStyles.BOLD).append(this).toText()
fun Text.italic(): Text = Texts.builder().style(TextStyles.ITALIC).append(this).toText()
fun Text.obfuscated(): Text = Texts.builder().style(TextStyles.OBFUSCATED).append(this).toText()
fun Text.reset(): Text = Texts.builder().style(TextStyles.RESET).append(this).toText()
fun Text.strikethrough(): Text = Texts.builder().style(TextStyles.STRIKETHROUGH).append(this).toText()
fun Text.underline(): Text = Texts.builder().style(TextStyles.UNDERLINE).append(this).toText()

// The operator keyword marks extension functions used as unary or binary operators.
operator fun Text.plus(other: Text): Text = Texts.builder().append(this).append(other).toText()
operator fun Text.plus(other: String): Text = Texts.builder().append(this).append(Texts.of(other)).toText()

fun <T : ClickAction<*>> Text.click(action: T): Text = Texts.builder().append(this).onClick(action).toText()
fun <T : HoverAction<*>> Text.hover(action: T): Text = Texts.builder().append(this).onHover(action).toText()
fun <T : ShiftClickAction<*>> Text.shiftClick(action: T): Text = Texts.builder().append(this).onShiftClick(action).toText()

fun String.t() = Texts.of(this)
fun String.aqua(): Text = t().aqua()
fun String.black(): Text = t().black()
fun String.blue(): Text = t().blue()
fun String.darkAqua(): Text = t().darkAqua()
fun String.darkBlue(): Text = t().darkBlue()
fun String.darkGray(): Text = t().darkGray()
fun String.darkGreen(): Text = t().darkGreen()
fun String.darkPurple(): Text = t().darkPurple()
fun String.darkRed(): Text = t().darkRed()
fun String.gold(): Text = t().gold()
fun String.gray(): Text = t().gray()
fun String.green(): Text = t().green()
fun String.lightPurple(): Text = t().lightPurple()
fun String.red(): Text = t().red()
fun String.yellow(): Text = t().yellow()
fun String.white(): Text = t().white()

fun String.bold(): Text = t().bold()
fun String.italic(): Text = t().italic()
fun String.obfuscated(): Text = t().obfuscated()
fun String.reset(): Text = t().reset()
fun String.strikethrough(): Text = t().strikethrough()
fun String.underline(): Text = t().underline()

fun <T : ClickAction<*>> String.click(action: T): Text = t().click(action)
fun <T : HoverAction<*>> String.hover(action: T): Text = t().hover(action)
fun <T : ShiftClickAction<*>> String.shiftClick(action: T): Text = t().shiftClick(action)
