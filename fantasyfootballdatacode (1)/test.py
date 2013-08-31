import xml.etree.ElementTree as ElementTree
filename = 'schedule.xml'
tree = ElementTree.parse(filename)
root = tree.getroot()
print root.tag
print root.attrib
# for week in root:
#     print week.tag
#     print week.attrib
#     for key in week.attrib:
#         print key
#         print week.attrib[key]
# print root.findall('week')
# for week in root.findall('week'):
#     for game in week.findall('game'):
#         home = game.find('home').text
#         print home
#         away = game.find('away').text
#         print away
#         print week.attrib
for week in root:
    print week.attrib
    for game in week:
        print game.attrib
print root[0].attrib
print root[0][0][0].text