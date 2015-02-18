import basis._
import basis.collections._
import basis.data._
import basis.text._

package object recon {
  implicit def RecordBuilder: Builder[Item] with From[Record] with State[Record] = Record.Builder
  implicit def TextBuilder: StringBuilder with From[Text] with State[Text] = Text.Builder
  implicit def DataFramer: Framer with From[Data] with State[Data] = Data.Framer

  implicit def StringToText: String => Text = Recon.StringToText
  implicit def IntToNumber: Int => Number = Recon.IntToNumber
  implicit def LongToNumber: Long => Number = Recon.LongToNumber
  implicit def FloatToNumber: Float => Number = Recon.FloatToNumber
  implicit def DoubleToNumber: Double => Number = Recon.DoubleToNumber
  implicit def BooleanToValue: Boolean => Value = Recon.BooleanToValue

  implicit def ReconStringContext(stringContext: StringContext): ReconStringContext[Recon.type] =
    macro ReconMacros.globalReconStringContext

  def ReconParser: Recon.ReconParser.type = Recon.ReconParser
}
