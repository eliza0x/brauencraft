package brauencraft.common.util

trait BaseUtil {
  def getClassName: String = getClass.getSimpleName.toLowerCase()
}
